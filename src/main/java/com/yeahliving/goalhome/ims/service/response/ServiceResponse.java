package com.yeahliving.goalhome.ims.service.response;

/**
 * Created by xingfeiy on 10/1/15.
 */
public class ServiceResponse {
    public ServiceResponse() {}

    public ServiceResponse(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    protected Status status = Status.OK;

    protected String message = "Ok";

    public enum Status {
        OK(202),

        NOT_FOUND(404),

        FORBIDDEN(403),

        FOUND(302),

        NOT_UPDATED(304),

        BAD_REQUEST(400),

        DB_FAILED(601),

        CONSTRAINT_VIOLATION(709),

        UNKNOWN_EXCEPTION(799);

        private int code = 0;

        private Status(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
