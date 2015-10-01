package com.yeahliving.goalhome.ims.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class GoHoRoomContainer {
    private List<GoHoRoom> rooms = new ArrayList<>();

    public List<GoHoRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<GoHoRoom> rooms) {
        this.rooms = rooms;
    }
}
