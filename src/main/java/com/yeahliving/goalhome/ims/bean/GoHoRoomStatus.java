package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 9/28/15.
 */
public enum GoHoRoomStatus {
    MASTER,

    SECOND,

    LIVING,

    DINING,

    UNKNOWN;

    public static GoHoRoomStatus parse(String str) {
        for(GoHoRoomStatus type : GoHoRoomStatus.values()) {
            if(StringUtils.equalsIgnoreCase(str, type.name())) {
                return type;
            }
        }
        return UNKNOWN;
    }
}