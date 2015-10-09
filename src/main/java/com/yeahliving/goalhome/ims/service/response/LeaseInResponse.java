package com.yeahliving.goalhome.ims.service.response;


import com.yeahliving.goalhome.ims.bean.GoHoLeaseIn;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class LeaseInResponse extends ServiceResponse {
    private GoHoLeaseIn object;

    public LeaseInResponse() {}

    public LeaseInResponse(Status status, String message) {
        super(status, message);
    }

    public GoHoLeaseIn getObject() {
        return object;
    }

    public void setObject(GoHoLeaseIn object) {
        this.object = object;
    }
}
