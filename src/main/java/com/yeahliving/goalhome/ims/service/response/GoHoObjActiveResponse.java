package com.yeahliving.goalhome.ims.service.response;

import com.yeahliving.goalhome.ims.bean.GoHoObject;

/**
 * Created by xingfeiy on 10/2/15.
 */
public class GoHoObjActiveResponse extends ServiceResponse {
    private GoHoObject object;

    public GoHoObjActiveResponse(Status status, String message) {
        super(status, message);
    }

    public GoHoObject getObject() {
        return object;
    }

    public void setObject(GoHoObject object) {
        this.object = object;
    }
}
