package com.yeahliving.goalhome.ims.service.response;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 10/1/15.
 */
public class ResponseUtils {
    public static String getConstraintViolationField(String message) {
        if(StringUtils.contains(message, "uc_address")) {}
        return "";
    }
}
