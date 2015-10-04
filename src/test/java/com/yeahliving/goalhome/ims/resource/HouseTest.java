package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPropertyStatus;
import com.yeahliving.goalhome.ims.service.AddressServiceTest;
import com.yeahliving.goalhome.ims.service.HouseService;
import com.yeahliving.goalhome.ims.service.LandlordServiceTest;
import com.yeahliving.goalhome.ims.service.response.GoHoObjActiveResponse;
import org.glassfish.jersey.server.validation.ValidationError;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class HouseTest extends ResourceTest {
    private static final GoHoHouse house_1;
    private static final GoHoHouse house_2;
    private static final GoHoHouse house_3;
    private static final GoHoHouse house_4;

    static {
        house_1 = new GoHoHouse();
        house_1.setAddress(AddressServiceTest.address);
        house_1.setAlias("川大精品公寓");
        house_1.setHouse_type("两室一厅");
        house_1.setArea(100);
        house_1.setStatus(GoHoPropertyStatus.PENDING.name());
        house_1.setFor_sell(false);
        house_1.setComments("空姐邻居");

        house_2 = new GoHoHouse();
        house_2.setAddress(AddressServiceTest.address1);
        house_2.setAlias("九眼桥豪庭");
        house_2.setHouse_type("两室一厅");
        house_2.setArea(160);
        house_2.setStatus(GoHoPropertyStatus.PENDING.name());
        house_2.setFor_sell(true);
        house_2.setComments("隔壁公安局");

        house_3 = new GoHoHouse();
        house_3.setAddress(AddressServiceTest.address2);
        house_3.setAlias("天府广场");
        house_3.setHouse_type("两室两厅");
        house_3.setArea(90);
        house_3.setStatus(GoHoPropertyStatus.LEASING.name());
        house_3.setFor_sell(false);
        house_3.setComments("每晚有广场舞");

        house_4 = new GoHoHouse();
        house_4.setAddress(AddressServiceTest.address3);
        house_4.setAlias("8888");
        house_4.setHouse_type("两室一厅");
        house_4.setArea(1000);
//        house_4.setRoom_ids("1,2,3");
//        house_4.setAgent_id(1);
        house_4.setStatus(GoHoPropertyStatus.DECORATING.name());
        house_4.setFor_sell(true);
//        house_4.setLandlord_id(123);
        house_4.setComments("隔壁公安局");
    }


    @Test
    public void testAddHouse() throws Exception {
        final WebTarget target = target()
                .path("house");
        final Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(house_3, MediaType.APPLICATION_JSON_TYPE));

//        final GoHoObjActiveResponse objActiveResponse = response.readEntity(GoHoObjActiveResponse.class);

//        assertEquals(500, response.getStatus());
//        assertTrue(getValidationMessageTemplates(response).contains("{address.already.existed}"));
        assertEquals(200, response.getStatus());
//        assertNotNull(house.getID());

//        final Response invalidResponse = target.request(MediaType.APPLICATION_JSON_TYPE)
//                .post(Entity.entity(house_1, MediaType.APPLICATION_JSON_TYPE));
//        assertEquals(500, invalidResponse.getStatus());
//        assertTrue(getValidationMessageTemplates(invalidResponse).contains("{house.already.exist}"));

//        assertEquals(200, target.path("" + lander.getId()).request(MediaType.APPLICATION_JSON_TYPE).delete().getGohoStatus());
    }

    @Test
    public void testSetHouse() throws Exception {
        final WebTarget target = target()
                .path("house/set/100000/room");
        Response response = target.
                request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(RoomTest.room1, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());

        response = target.
                request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(RoomTest.room2, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(200, response.getStatus());
    }

    @Test
    public void testSetHouseLandlord() throws Exception {
        final WebTarget target = target()
                .path("house/set/100000/landlord");
        Response response = target.
                request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(LandlordServiceTest.landlord1, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());

        final WebTarget target2 = target()
                .path("house/set/100001/landlord");
        Response response2 = target2.
                request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(LandlordServiceTest.landlord1, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response2.getStatus());
    }

    @Test
    public void testUpdateHouse() throws Exception {
        GoHoHouse house = HouseService.getByID(100000);
        house.setAlias("Modified");
        house.setArea(168);

        final WebTarget target = target()
                .path("house");
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(house, MediaType.APPLICATION_JSON_TYPE));

//        final GoHoHouse updatedHouse = response.readEntity(GoHoHouse.class);
        assertEquals(200, response.getStatus());
//        assertEquals(house.getID(), updatedHouse.getID());
//        assertEquals(updatedHouse.getArea(), 168);
//        assertEquals(updatedHouse.getAlias(), "Modified");
    }

    @Test
    public void testUpdateHouse2() throws Exception {
        GoHoHouse house = HouseService.getByID(100001);
        house.getAddress().setStreet("nanguang");

        final WebTarget target = target()
                .path("house");
        Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(house, MediaType.APPLICATION_JSON_TYPE));

//        final GoHoHouse updatedHouse = response.readEntity(GoHoHouse.class);
        assertEquals(200, response.getStatus());
//        assertEquals(house.getID(), updatedHouse.getID());
//        assertEquals(updatedHouse.getArea(), 168);
//        assertEquals(updatedHouse.getAlias(), "Modified");
    }

    @Test
    public void testGetHouseByID() throws Exception {
        final WebTarget target = target()
                .path("house");
        Response response = target.path("100013").request(MediaType.APPLICATION_JSON_TYPE).get();

        final GoHoHouse house = response.readEntity(GoHoHouse.class);
        assertEquals(200, response.getStatus());
//        assertEquals(100000, house.getID());
    }

    @Test
    public void testSearchByStreet() throws Exception {
        final WebTarget target = target().path("house");
        Response response = target.path("search/street")
                .queryParam("q", "南光路")
//                .queryParam("q", "nanguang")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoHouseContainer container = response.readEntity(GoHoHouseContainer.class);
        assertTrue(container.getHouses().size() > 0);
    }

    private List<ValidationError> getValidationErrorList(final Response response) {
        return response.readEntity(new GenericType<List<ValidationError>>() {});
    }

    private Set<String> getValidationMessageTemplates(final Response response) {
        return getValidationMessageTemplates(getValidationErrorList(response));
    }

    private Set<String> getValidationMessageTemplates(final List<ValidationError> errors) {
        final Set<String> templates = new HashSet<String>();
        for (final ValidationError error : errors) {
            templates.add(error.getMessageTemplate());
        }
        return templates;
    }
}
