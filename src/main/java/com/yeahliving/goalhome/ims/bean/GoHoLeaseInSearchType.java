package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 10/8/15.
 */
public enum GoHoLeaseInSearchType {
    MY_OPENING("myopening"),

    MY_ALL("myall"),

    MY_CLOSED("mycolsed"),

    OPENING("opening"),

    ALL("all"),

    CLOSED("closed");

    private String value = StringUtils.EMPTY;

    private GoHoLeaseInSearchType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static GoHoLeaseInSearchType parse(String value) {
        for(GoHoLeaseInSearchType type : GoHoLeaseInSearchType.values()) {
            if(StringUtils.equalsIgnoreCase(value, type.getValue())) {
                return type;
            }
        }
        return null;
    }
}
