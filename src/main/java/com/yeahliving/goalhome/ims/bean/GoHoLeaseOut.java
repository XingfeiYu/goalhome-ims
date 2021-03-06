package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class GoHoLeaseOut extends GoHoObject {

    private Date lease_start_date;

    private Date lease_end_date;

    private int start_utility_record = Integer.MIN_VALUE;

    private int end_utility_record = Integer.MIN_VALUE;

    private int lease_unit_id = Integer.MIN_VALUE;

    private int tenant_id = Integer.MIN_VALUE;

    private int agent_id = Integer.MIN_VALUE;

    private float fee_per_month = 0;

    private float prepayment = 0;

    private Date first_bill_date;

    private int bill_period = 3;

    private float deposit = 0;

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

    public int getLease_unit_id() {
        return lease_unit_id;
    }

    public void setLease_unit_id(int lease_unit_id) {
        this.lease_unit_id = lease_unit_id;
    }

    public int getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(int tenant_id) {
        this.tenant_id = tenant_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }

    public float getFee_per_month() {
        return fee_per_month;
    }

    public void setFee_per_month(float fee_per_month) {
        this.fee_per_month = fee_per_month;
    }

    public Date getFirst_bill_date() {
        return first_bill_date;
    }

    public void setFirst_bill_date(Date first_bill_date) {
        this.first_bill_date = first_bill_date;
    }

    public int getBill_period() {
        return bill_period;
    }

    public void setBill_period(int bill_period) {
        this.bill_period = bill_period;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
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

    public float getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(float prepayment) {
        this.prepayment = prepayment;
    }

    public int getStart_utility_record() {
        return start_utility_record;
    }

    public void setStart_utility_record(int start_utility_record) {
        this.start_utility_record = start_utility_record;
    }

    public int getEnd_utility_record() {
        return end_utility_record;
    }

    public void setEnd_utility_record(int end_utility_record) {
        this.end_utility_record = end_utility_record;
    }
}
