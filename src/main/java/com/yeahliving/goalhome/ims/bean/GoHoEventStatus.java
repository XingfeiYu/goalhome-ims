package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/12/15.
 */
public enum GoHoEventStatus {
    PENDING(0),

    PROGRESS(1),

    END(-1);

    int code = 0;
    private GoHoEventStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static GoHoEventStatus parse(int code) {
        for(GoHoEventStatus status : GoHoEventStatus.values()) {
            if(status.getCode() == code) {
                return status;
            }
        }
        return null;
    }

}
