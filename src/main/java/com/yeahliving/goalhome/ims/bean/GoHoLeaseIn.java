package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by xingfeiy on 9/30/15.
 */
@XmlRootElement(name="goholeasein")
@XmlAccessorType(XmlAccessType.FIELD)
public class GoHoLeaseIn extends GoHoObject {

    private Date lease_start_date;

    private Date lease_end_date;

    private int agent_id = Integer.MIN_VALUE;

//    private int landlord_id = Integer.MIN_VALUE;

    private int house_id = Integer.MIN_VALUE;

    private float fee_per_month = 0;

//    private float fee_total = 0;

    private  float deposit = 0;

    private int event_status_code = GoHoEventStatus.PENDING.code;

//    private int deposit_months = 1;

    @XmlElement(name = "pic_url")
    private String pic_url = StringUtils.EMPTY;

    @XmlElement(name = "doc_url")
    private String doc_url = StringUtils.EMPTY;

    private String comments = StringUtils.EMPTY;

    public Date getLease_start_date() {
        return lease_start_date;
    }

    public void setLease_start_date(Date lease_start_date) {
        this.lease_start_date = lease_start_date;
    }

    public Date getLease_end_date() {
        return lease_end_date;
    }

    public void setLease_end_date(Date lease_end_date) {
        this.lease_end_date = lease_end_date;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public float getFee_per_month() {
        return fee_per_month;
    }

    public void setFee_per_month(float fee_per_month) {
        this.fee_per_month = fee_per_month;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public int getEvent_status_code() {
        return event_status_code;
    }

    public void setEvent_status_code(int event_status_code) {
        this.event_status_code = event_status_code;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
