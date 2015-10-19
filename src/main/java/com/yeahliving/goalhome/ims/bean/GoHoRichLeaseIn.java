package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/13/15.
 */
public class GoHoRichLeaseIn extends GoHoObject{
    private GoHoHouse house;

    private GoHoObjContainer roomContainer;

    private GoHoLandlord landlord;

    private GoHoHouseVendor houseVendor;

    private GoHoLeaseIn leaseIn;

    public GoHoRichLeaseIn() {
    }

    public GoHoRichLeaseIn(GoHoHouse house, GoHoLeaseIn leaseIn) {
        this.house = house;
        this.leaseIn = leaseIn;
    }

    public GoHoHouse getHouse() {
        return house;
    }

    public void setHouse(GoHoHouse house) {
        this.house = house;
    }

    public GoHoObjContainer getRoomContainer() {
        return roomContainer;
    }

    public void setRoomContainer(GoHoObjContainer roomContainer) {
        this.roomContainer = roomContainer;
    }

    public GoHoLandlord getLandlord() {
        return landlord;
    }

    public void setLandlord(GoHoLandlord landlord) {
        this.landlord = landlord;
    }

    public GoHoHouseVendor getHouseVendor() {
        return houseVendor;
    }

    public void setHouseVendor(GoHoHouseVendor houseVendor) {
        this.houseVendor = houseVendor;
    }

    public GoHoLeaseIn getLeaseIn() {
        return leaseIn;
    }

    public void setLeaseIn(GoHoLeaseIn leaseIn) {
        this.leaseIn = leaseIn;
    }
}
