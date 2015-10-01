package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 9/28/15.
 */
public enum GoHoPropertyStatus {
    LEASING,

    PARTIAL_LEASING,

    PENDING,

    DECORATING,

    CHECK_OUT;

    public static GoHoPropertyStatus parse(String value) {
        for(GoHoPropertyStatus status : GoHoPropertyStatus.values()) {
            if(StringUtils.equalsIgnoreCase(status.name(), value)) {
                return status;
            }
        }
        return null;
    }
}
