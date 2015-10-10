package com.yeahliving.goalhome.ims.service.response;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;
/**
 * Created by xingfeiy on 10/2/15.
 */
public class GoHoHouseResponse extends ServiceResponse {
    private GoHoHouse object;

    public GoHoHouseResponse() {}

    public GoHoHouseResponse(Status status, String message) {
        super(status, message);
    }

    public GoHoHouse getObject() {
        return object;
    }

    public void setObject(GoHoHouse object) {
        this.object = object;
    }
}
