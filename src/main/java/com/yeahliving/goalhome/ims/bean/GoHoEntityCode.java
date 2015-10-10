package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/9/15.
 */
public enum GoHoEntityCode {
    HOUSE(1),

    ROOM(2),

    LANDLORD(3),

    EMPLOYEE(4),

    EMPLOYEE_LOGIN(5),

    ADDRESS(6),

    HOUSE_VENDOR(7),

    HOUSE_LANDLORD_RELATION(8),

    LEASE_IN(9),

    LEASE_OUT(10),

    LEASE_UNIT(11),

    TENANT(12);

    private int code = 0;

    private GoHoEntityCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GoHoEntityCode parse(int code) {
        for(GoHoEntityCode entityCode : GoHoEntityCode.values()) {
            if(entityCode.getCode() == code) {
                return entityCode;
            }
        }
        return null;
    }
}

