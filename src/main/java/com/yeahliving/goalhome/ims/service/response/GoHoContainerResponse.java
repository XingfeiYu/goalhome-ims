package com.yeahliving.goalhome.ims.service.response;

import com.yeahliving.goalhome.ims.bean.GoHoObjContainer;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class GoHoContainerResponse extends ServiceResponse {

    private GoHoObjContainer container;

    public GoHoContainerResponse() {
    }

    public GoHoContainerResponse(Status status, String message, GoHoObjContainer container) {
        super(status, message);
        this.container = container;
    }

    public GoHoObjContainer getContainer() {
        return container;
    }

    public void setContainer(GoHoObjContainer container) {
        this.container = container;
    }
}
