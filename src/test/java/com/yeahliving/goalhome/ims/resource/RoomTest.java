package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoRoom;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by xingfeiy on 10/1/15.
 */
public class RoomTest extends ResourceTest {
    public static final GoHoRoom room1;
    public static final GoHoRoom room2;
    public static final GoHoRoom room3;
    static {
        room1 = new GoHoRoom();
        room1.setHouse_id(100000);
        room1.setArea(28);
        room1.setRoom_type("主卧");
        room1.setSelf_br(true);
        room1.setFacilities("床、彩电、沙发、空调");

        room2 = new GoHoRoom();
        room2.setHouse_id(100000);
        room2.setArea(18);
        room2.setRoom_type("次卧");
        room2.setSelf_br(true);
        room2.setFacilities("床、彩电、空调");

        room3 = new GoHoRoom();
        room3.setHouse_id(100000);
        room3.setArea(18);
        room3.setRoom_type("客厅");
        room3.setSelf_br(true);
        room3.setFacilities("餐桌、彩电、空调");

    }

    @Test
    public void testAddRoom() throws Exception {
        final WebTarget target = target()
                .path("room");
        final Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(room3, MediaType.APPLICATION_JSON_TYPE));

        final GoHoRoom room = response.readEntity(GoHoRoom.class);

        assertEquals(200, response.getStatus());
        assertNotNull(room.getId());

    }
}
