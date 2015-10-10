package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class GoHoHouseVendor extends GoHoObject{
    private int id = Integer.MIN_VALUE;

    private int house_id = Integer.MIN_VALUE;

    private int contact = Integer.MIN_VALUE;

    private int type_code = Type.OTHERS.getValue();

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getType_code() {
        return type_code;
    }

    public void setType_code(int type_code) {
        this.type_code = type_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public enum Type{
        LANDLORD(1),  //from landlord.

        INDIVIDUAL(2), //recommend by individual.

        AGENCY(3), //from agency.

        PATTERN(4),  //from pattern.

        SELF_DEV(5),

        OTHERS(6);  //

        private int value = 0;

        private Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

}

