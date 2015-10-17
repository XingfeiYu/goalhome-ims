package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.service.LandlordServiceTest;
import com.yeahliving.goalhome.ims.service.response.GoHoHouseResponse;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class WholeProcessTest extends ResourceTest {

    @Test
    public void leaseInTest() throws Exception {
        //default page display, display all available leasable houses/rooms.
        final WebTarget target = target()
                .path("lease_units/list");
        Response response = target.queryParam("status", 1)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        //======================Start a lease in======================
        //click "Lease In" button.
        //go to the add address dialog or page.
        final WebTarget houseTarget = target()
                .path("house");
        response = houseTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.house_1, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());

        //next page, add landlord info.

        final GoHoHouseResponse objActiveResponse = response.readEntity(GoHoHouseResponse.class);
        int houseID = objActiveResponse.getObject().getId();
        assertTrue(houseID > 0);

        //next page, add landlord info.
        response = houseTarget.path("set")
                .path(Integer.toString(houseID))
                .path("landlord")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.landlord1, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());

        //next page, add rooms info
        response = houseTarget.path("set")
                .path(Integer.toString(houseID))
                .path("room")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.room1, MediaType.APPLICATION_JSON_TYPE));

        //finish the house adding work, click finish button go to the lease in page.
        final WebTarget leaseInTarget = target()
                .path("lease_in");

        response = leaseInTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.leaseIn1, MediaType.APPLICATION_JSON_TYPE));

        //======================Finish a lease in======================

        //======================Search a lease in======================

    }
}
