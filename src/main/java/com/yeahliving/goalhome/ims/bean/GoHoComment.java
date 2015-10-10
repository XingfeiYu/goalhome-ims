package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class GoHoComment extends GoHoObject {
    private int id = Integer.MIN_VALUE;

    private int entity_id = Integer.MIN_VALUE;

    private int entity_code = 0;

    private String comments = StringUtils.EMPTY;

    private int uid = Integer.MIN_VALUE;

    private Timestamp tstamp;

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

    public int getEntity_code() {
        return entity_code;
    }

    public void setEntity_code(int entity_code) {
        this.entity_code = entity_code;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Timestamp getTstamp() {
        return tstamp;
    }

    public void setTstamp(Timestamp tstamp) {
        this.tstamp = tstamp;
    }
}
