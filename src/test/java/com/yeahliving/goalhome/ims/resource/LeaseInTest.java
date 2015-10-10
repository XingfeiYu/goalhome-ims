package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.*;
import com.yeahliving.goalhome.ims.service.response.GoHoContainerResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;
import com.yeahliving.goalhome.ims.service.response.ServiceResponse;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class LeaseInTest extends ResourceTest  {
    private static final GoHoLeaseIn leaseIn1;
    static {
        Calendar start = new GregorianCalendar(2015,10,28);
        Calendar end = new GregorianCalendar(2016,9,28);
        leaseIn1 = new GoHoLeaseIn();
        leaseIn1.setHouse_id(1000017);
        leaseIn1.setLease_start_date(start.getTime());
        leaseIn1.setLease_end_date(end.getTime());
        leaseIn1.setAgent_id(300);
        leaseIn1.setFee_per_month(2350.5f);
        leaseIn1.setDeposit(1000.43f);
    }

    @Test
    public void testAddHouse() throws Exception {
        //http://localhost:9998/goalhome-ims/lease_in/house
        final WebTarget target = target()
                .path("lease_in");
        Response response = target.path("house")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.house_1, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());

        GoHoObjResponse objResponse = response.readEntity(GoHoObjResponse.class);
        assertEquals(objResponse.getStatus().getCode(), 202);
        GoHoHouse house = (GoHoHouse)objResponse.getGoHoObj();
        int houseID = house.getID();
        assertTrue(houseID > 0);

        //http://localhost:9998/goalhome-ims/lease_in/house/landlord?house_id=100005
        //add landlord
        response = target.path("house")
                .path("landlord")
                .queryParam("house_id", houseID)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(TestObjects.landlord2, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        objResponse = response.readEntity(GoHoObjResponse.class);
        assertEquals(objResponse.getStatus().getCode(), 202);
        GoHoLandlord landlord = (GoHoLandlord)objResponse.getGoHoObj();
        assertTrue(landlord.getId() > 0);

//        http://localhost:9998/goalhome-ims/lease_in/house/room?house_id=100005
        //add rooms
        List<GoHoRoom> rooms = new ArrayList<>();
        rooms.add(TestObjects.room1);
        rooms.add(TestObjects.room2);
        rooms.add(TestObjects.room3);
        GoHoObjContainer container = new GoHoObjContainer(rooms);
        response = target.path("house")
                .path("room")
                .queryParam("house_id", houseID)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(container, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        GoHoContainerResponse containerResponse = response.readEntity(GoHoContainerResponse.class);
        assertEquals(containerResponse.getStatus().getCode(), 202);

//        response = target.path("house")
//                .path("vendor")
//                .queryParam("house_id", houseID)
//                .request(MediaType.APPLICATION_JSON_TYPE)
//                .post(Entity.entity(TestObjects.landlord2, MediaType.APPLICATION_JSON_TYPE));
//        assertEquals(200, response.getStatus());
//        objResponse = response.readEntity(GoHoObjResponse.class);
//        assertEquals(objResponse.getStatus().getCode(), 202);
//        GoHoLandlord landlord = (GoHoLandlord)objResponse.getGoHoObj();
//        assertTrue(landlord.getId() > 0);

        //http://localhost:9998/goalhome-ims/lease_in?house_id=100005
        response = target.queryParam("house_id", houseID)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(leaseIn1, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        objResponse = response.readEntity(GoHoObjResponse.class);
        assertEquals(objResponse.getStatus().getCode(), 202);


    }

    @Test
    public void testAddLeaseUnit() throws Exception {
        //the first page, show all houses which are waiting for lease out.
        WebTarget unitTarget = target().path("lease_units");
        Response response = unitTarget.path("list")
                .queryParam("agent_id", 100)
                .queryParam("unit_type", 1)
                .queryParam("status", GoHoEntityStatusCode.LEASABLE.getCode())
                .request(MediaType.APPLICATION_JSON_TYPE).get();
        assertEquals(200, response.getStatus());
        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertEquals(searchResponse.getStatus().getCode(), 202);
    }



    /**
     * First step, test add new lease in.
     * @throws Exception
     */
    @Test
    public void testAddLeaseIn() throws Exception {
        final WebTarget target = target()
                .path("lease_in");
        final Response response = target.path("house").path("100000").request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(leaseIn1, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
        GoHoObjResponse objResponse = response.readEntity(GoHoObjResponse.class);
        assertEquals(objResponse.getStatus().getCode(), 202);
    }

    @Test
    public void testCloseLeaseIn() throws Exception {
        final WebTarget target = target()
                .path("lease_in/close");
        final Response response = target.path("1").request(MediaType.APPLICATION_JSON_TYPE).get();
        GoHoObjResponse objResponse = response.readEntity(GoHoObjResponse.class);

        assertEquals(200, response.getStatus());
    }

    @Test
    public void testSearchAllLeaseInPage1() throws Exception {
        final WebTarget target = target().path("lease_in");

        Response response = target.path("search")
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(searchResponse.getContainer().getObj().size() > 0);
    }

    @Test
    public void testSearchAllLeaseInInvalidPage() throws Exception {
        final WebTarget target = target().path("lease_in");

        Response response = target.path("search")
                .queryParam("page", 1000)
                .queryParam("per_page", 5)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(ServiceResponse.Status.BAD_REQUEST.equals(searchResponse.getStatus()));
        assertTrue(searchResponse.getContainer().getObj().size() == 0);
    }

    @Test
    public void testSearchAllOpeningLeaseIn() throws Exception {
        final WebTarget target = target().path("lease_in");

        Response response = target.path("search")
                .queryParam("status", 1)
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getOpening() == 1);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(1)).getOpening() == 1);
    }

    @Test
    public void testSearchAllClosedLeaseIn() throws Exception {
        final WebTarget targetClose = target()
                .path("lease_in/close");
        targetClose.path("23").request(MediaType.APPLICATION_JSON_TYPE).get();

        final WebTarget target = target().path("lease_in");

        Response response = target.path("search")
                .queryParam("status", 0)
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getOpening() == 0);
    }

    @Test
    public void testSearchMyOpeningLeaseIn() throws Exception {

        final WebTarget target = target().path("lease_in");

        Response response = target.path("search")
                .queryParam("id", 200)
                .queryParam("status", 1)
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());
        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(searchResponse.getContainer().getObj().size() > 0);
        assertTrue(((GoHoLeaseIn) searchResponse.getContainer().getObj().get(0)).getOpening() == 1);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getAgent_id() == 200);
    }

    @Test
    public void testSearchMyOneMonthLeaseIn() throws Exception {

        final WebTarget target = target().path("lease_in");

        Calendar start = new GregorianCalendar(2015,10,28);
        Calendar end = new GregorianCalendar(2016,10,28);

        Response response = target.path("search")
                .queryParam("id", 100)
                .queryParam("status", 1)
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .queryParam("from", start.getTime().getTime())
                .queryParam("to", end.getTime().getTime())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());
        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(searchResponse.getContainer().getObj().size() > 0);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getOpening() == 1);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getAgent_id() == 100);
    }

    @Test
    public void testSearchAllOneMonthLeaseIn() throws Exception {

        final WebTarget target = target().path("lease_in");

        Calendar start = new GregorianCalendar(2015,10,28);
        Calendar end = new GregorianCalendar(2016,10,28);

        Response response = target.path("search")
//                .queryParam("id", 100)
                .queryParam("status", 1)
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .queryParam("from", start.getTime().getTime())
                .queryParam("to", end.getTime().getTime())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());
        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(searchResponse.getContainer().getObj().size() > 0);
        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getOpening() == 1);
//        assertTrue(((GoHoLeaseIn)searchResponse.getContainer().getObj().get(0)).getAgent_id() == 100);
    }

    @Test
    public void testSearchMyOneInvalidMonthLeaseIn() throws Exception {

        final WebTarget target = target().path("lease_in");

        Calendar start = new GregorianCalendar(2018,10,28);
        Calendar end = new GregorianCalendar(2019,10,28);

        Response response = target.path("search")
                .queryParam("id", 100)
                .queryParam("status", 1)
                .queryParam("page", 1)
                .queryParam("per_page", 5)
                .queryParam("from", start.getTime().getTime())
                .queryParam("to", end.getTime().getTime())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());
        GoHoSearchResponse searchResponse = response.readEntity(GoHoSearchResponse.class);
        assertTrue(searchResponse.getContainer().getObj().size() == 0);
    }

    @Test
    public void testSearchLeaseIn() throws Exception {
        final WebTarget target = target().path("lease_in");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd");
        Calendar start = new GregorianCalendar(2015,10,28);
        Calendar end = new GregorianCalendar(2016,9,28);

        Response response = target.path("search")
//                .queryParam("id", 200)
                .queryParam("status", 1)
                .queryParam("page", 1)
                .queryParam("per_page", 10)
                .queryParam("from", start.getTime().getTime())
                .queryParam("to", end.getTime().getTime())
                .queryParam("date_type", "lease_start_date")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoSearchResponse container = response.readEntity(GoHoSearchResponse.class);
        if(container == null) {}
    }
}
