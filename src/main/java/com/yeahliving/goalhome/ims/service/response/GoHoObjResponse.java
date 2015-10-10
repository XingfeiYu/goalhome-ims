package com.yeahliving.goalhome.ims.service.response;

import com.yeahliving.goalhome.ims.bean.GoHoObject;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class GoHoObjResponse extends ServiceResponse {

    private GoHoObject goHoObj;

    public GoHoObjResponse() {
        super();
    }

    public GoHoObjResponse(Status status, String message, GoHoObject goHoObj) {
        super(status, message);
        this.goHoObj = goHoObj;
    }

    public GoHoObject getGoHoObj() {
        return goHoObj;
    }

    public void setGoHoObj(GoHoObject goHoObj) {
        this.goHoObj = goHoObj;
    }
}
