package com.yeahliving.goalhome.ims.exception;

import javax.ws.rs.WebApplicationException;

/**
 * Created by xingfeiy on 10/6/15.
 */
public class DBRecordAlreadyExistedException extends WebApplicationException {

    public DBRecordAlreadyExistedException() {
//        super(Responses.notFound().build());
    }

    public DBRecordAlreadyExistedException(String message) {
//        super(javax.ws.rs.core.Response.status(javax.ws.rs.core.Responses.NOT_FOUND).
//                entity(message).type("text/plain").build());
    }
}
