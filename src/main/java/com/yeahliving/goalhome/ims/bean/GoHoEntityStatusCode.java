package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/9/15.
 */
public enum GoHoEntityStatusCode {
    LEASABLE(1),  //means this entity is waiting for lease.

    UNLEASABLE(0), //means this entity is valid, but somehow, not available for lease right now, likes in the decorating.

    OCCUPIED(-1), // means this entity is leasing right now.

    INVALID(Integer.MIN_VALUE); // means this entity is not valid anymore.

    private int code = 1;

    private GoHoEntityStatusCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GoHoEntityStatusCode parse(int code) {
        for(GoHoEntityStatusCode statusCode : GoHoEntityStatusCode.values()) {
            if(statusCode.getCode() == code) {
                return statusCode;
            }
        }
        return null;
    }
}
