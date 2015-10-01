package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by xingfeiy on 9/28/15.
 */
@XmlRootElement(name = "room")
public class GoHoRoom extends GoHoObject {
    @XmlAttribute(name = "id")
    private int id = Integer.MIN_VALUE;

    private int house_id = Integer.MIN_VALUE;

    @XmlElement(name = "room_type")
    private String room_type = StringUtils.EMPTY;

    @XmlElement(name = "status")
    private String status = StringUtils.EMPTY;

    @XmlElement(name = "area")
    private int area = Integer.MIN_VALUE;

    @XmlElement(name = "self_br")
    private int selfBathroom = 0;

    @XmlElement(name = "facilities")
    private String facilities = StringUtils.EMPTY;

    @XmlElement(name = "pic_url")
    private String picPaths = StringUtils.EMPTY;

    private String comments = StringUtils.EMPTY;

    @XmlElement(name = "Timestamp")
    private Timestamp tstamp;

    public enum TYPE {
        MASTER,

        SECOND,

        LIVING,

        DINING,

        UNKNOWN;

        public static TYPE parse(String str) {
            for(TYPE type : TYPE.values()) {
                if(StringUtils.equalsIgnoreCase(str, type.name())) {
                    return type;
                }
            }
            return UNKNOWN;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public boolean isSelfBathroom() {
        return this.selfBathroom == 1;
    }

    public void setSelfBathroom(boolean selfBathroom) {
        this.selfBathroom = selfBathroom ? 1 : 0;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getPicPaths() {
        return picPaths;
    }

    public void setPicPaths(String picPaths) {
        this.picPaths = picPaths;
    }

    public Timestamp getTstamp() {
        return tstamp;
    }

    public void setTstamp(Timestamp tstamp) {
        this.tstamp = tstamp;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

