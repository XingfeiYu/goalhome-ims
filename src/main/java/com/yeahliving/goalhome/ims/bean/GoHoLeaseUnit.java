package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/8/15.
 */
public class GoHoLeaseUnit extends GoHoObject {

    private int id = Integer.MIN_VALUE;

    private int house_id = Integer.MIN_VALUE;

    /*
    1 => house, 0 => room.
     */
    private int unit_type = 1;

    private int agent_id = Integer.MIN_VALUE;

    /*
    1 - leasable, 0 - occupied, -1 - unleasable.
     */
    private int status = 0;
}
