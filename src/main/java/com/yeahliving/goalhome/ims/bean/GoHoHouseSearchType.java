package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 9/30/15.
 */
public enum GoHoHouseSearchType {
    SEARCH_BY_STREET("street"),

    SEARCH_BY_CITY("city"),

    SEARCH_BY_DISTRICT("district"),

    SEARCH_BY_COMPLEX("complex"),

    SEARCH_BY_PROVINCE("province"),

    SEARCH_BY_KEYWORDS("keywords"),

    SEARCH_AVAILABLE("available"),

    SEARCH_BY_AGENT("agent"),

    SEARCH_NEAR_BY("nearby");

    private String value = StringUtils.EMPTY;

    private GoHoHouseSearchType(String value) {
        this.value = value;
    }

    public static GoHoHouseSearchType parse(String str) {
        for(GoHoHouseSearchType type : GoHoHouseSearchType.values()) {
            if(StringUtils.equalsIgnoreCase(type.value, str)) {
                return type;
            }
        }
        return null;
    }
}
