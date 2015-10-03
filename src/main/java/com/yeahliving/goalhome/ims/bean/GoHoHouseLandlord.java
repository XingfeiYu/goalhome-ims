package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/1/15.
 */
public class GoHoHouseLandlord extends GoHoObject {
    private int id = Integer.MIN_VALUE;

    private int landlord_id = Integer.MIN_VALUE;

    private int house_id = Integer.MIN_VALUE;

    private int expired = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLandlord_id() {
        return landlord_id;
    }

    public void setLandlord_id(int landlord_id) {
        this.landlord_id = landlord_id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public boolean isExpired() {
        return expired == 1;
    }

    public void setExpired(boolean expired) {
        this.expired = expired ? 1 : 0;
    }
}
