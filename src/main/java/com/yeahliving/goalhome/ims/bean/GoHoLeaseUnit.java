package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 10/8/15.
 */
public class GoHoLeaseUnit extends GoHoObject {

    private int id = Integer.MIN_VALUE;

    /*
    if the unit_type == 1, entity id == house_id.
     */
    private int entity_id = Integer.MIN_VALUE;

    private int house_id = Integer.MIN_VALUE;

    /*
    1 => house, 0 => room.
     */
    private int unit_type = 1;

    private int agent_id = Integer.MIN_VALUE;

    private int status = GoHoEntityStatusCode.LEASABLE.getCode();

    private String comments = StringUtils.EMPTY;

    public GoHoLeaseUnit() {
    }

    public GoHoLeaseUnit(int house_id, int agent_id) {
        this.house_id = house_id;
        this.entity_id = house_id;
        this.agent_id = agent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public int getUnit_type() {
        return unit_type;
    }

    public void setUnit_type(int unit_type) {
        this.unit_type = unit_type;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
