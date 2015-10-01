package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 9/28/15.
 */
@XmlRootElement(name = "house")
public class GoHoHouse extends GoHoObject {
    @XmlAttribute(name = "id")
    private int id = Integer.MIN_VALUE;

    @XmlElement(name = "address_id")
    private int address_id = Integer.MIN_VALUE;

    @XmlElement(name = "address")
    private GoHoAddress address = new GoHoAddress();

    @XmlElement(name = "alias")
    private String alias = StringUtils.EMPTY;

    @XmlElement(name = "area")
    private int area;

    @XmlElement(name = "house_type")
    private String house_type;

    @XmlElement(name = "comments")
    private String comments;

    @XmlElement(name = "for_sell")
    private int for_sell = 0;

//    @XmlElement(name = "landlord_id")
//    private int landlord_id = Integer.MIN_VALUE;

//    @XmlElement(name = "history_landlords")
//    private List<Integer> historyLandlords = new ArrayList<Integer>();

    @XmlElement(name = "status")
    private String status = StringUtils.EMPTY;

    private GoHoPropertyStatus gohoStatus = GoHoPropertyStatus.PENDING;

    @XmlElement(name = "pic_url")
    private String pic_url = StringUtils.EMPTY;

    @XmlElement(name = "doc_url")
    private String doc_url = StringUtils.EMPTY;

    @XmlElement(name = "Timestamp")
    private Timestamp tstamp;

//    @XmlElement(name = "agent")
    private String agent = StringUtils.EMPTY;

    //    @XmlElementWrapper(name = "rooms")
    @XmlElement(name = "rooms")
    private List<GoHoRoom> rooms = new ArrayList<GoHoRoom>();

//    @XmlElement(name = "room_ids")
//    private String room_ids = StringUtils.EMPTY;

    @XmlElement(name = "landlord")
    private GoHoLandlord landlord;


//    public String getRoom_ids() {
//        return room_ids;
//    }

//    public void setRoom_ids(String room_ids) {
//        this.room_ids = room_ids;
//    }


//    public int getAgent_id() {
//        return agent_id;
//    }
//
//    public void setAgent_id(int agent_id) {
//        this.agent_id = agent_id;
//    }

    public Timestamp getTstamp() {
        return tstamp;
    }

    public void setTstamp(Timestamp tstamp) {
        this.tstamp = tstamp;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }


    public int getID() {
        return id;
    }

    public void setID(int houseID) {
        this.id = houseID;
    }


    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isFor_sell() {
        return (this.for_sell == 1);
    }

    public void setFor_sell(boolean for_sell) {
        this.for_sell = for_sell ? 1 : 0;
    }

    public GoHoPropertyStatus getGohoStatus() {
        return gohoStatus;
    }

    public void setGohoStatus(GoHoPropertyStatus gohoStatus) {
        this.gohoStatus = gohoStatus;
        this.status = gohoStatus.name();
    }

    public GoHoAddress getAddress() {
        return address;
    }

    public void setAddress(GoHoAddress address) {
        this.address = address;
    }

    public GoHoLandlord getLandlord() {
        return landlord;
    }

    public void setLandlord(GoHoLandlord landlord) {
        this.landlord = landlord;
    }

//    public int getLandlord_id() {
//        return landlord_id;
//    }

//    public void setLandlord_id(int landlord_id) {
//        this.landlord_id = landlord_id;
//    }

    public List<GoHoRoom> getRooms() {
        return rooms;
    }

    public void setRooms(List<GoHoRoom> rooms) {
        this.rooms = rooms;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
//        gohoStatus = GoHoPropertyStatus.parse(status);
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getDoc_url() {
        return doc_url;
    }

    public void setDoc_url(String doc_url) {
        this.doc_url = doc_url;
    }
}
