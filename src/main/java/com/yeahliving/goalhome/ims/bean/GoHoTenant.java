package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xingfeiy on 9/30/15.
 */
@XmlRootElement(name = "tenant")
public class GoHoTenant {
    @XmlAttribute(name = "id")
    private int id = Integer.MIN_VALUE;

    @XmlElement(name = "tenant_name")
    private String tenant_name = StringUtils.EMPTY;

    @XmlElement(name = "age")
    private int age = Integer.MIN_VALUE;

    @XmlElement(name = "married")
    private int married = 0;

    @XmlElement(name = "identify")
    private String identify = StringUtils.EMPTY;

    @XmlElement(name = "gender")
    //0 - female, 1 - male, 2 - unknown
    private int gender = 0;

    @XmlElement(name = "phone")
    private String phone = StringUtils.EMPTY;

    @XmlElement(name = "mobile")
    private String mobile = StringUtils.EMPTY;

    @XmlElement(name = "sec_mobile")
    private String sec_mobile = StringUtils.EMPTY;

    @XmlElement(name = "email")
    private String email = StringUtils.EMPTY;

    @XmlElement(name = "qq")
    private String qq = StringUtils.EMPTY;

    @XmlElement(name = "wechat")
    private String wechat = StringUtils.EMPTY;

    @XmlElement(name = "hobby")
    private String hobby = StringUtils.EMPTY;

    @XmlElement(name = "buy_intention")
    private int buy_intention = 0;

    @XmlElement(name = "job")
    private String job = StringUtils.EMPTY;

    @XmlElement(name = "pic_url")
    private String pic_url = StringUtils.EMPTY;

    @XmlElement(name = "doc_url")
    private String doc_url = StringUtils.EMPTY;

    @XmlElement(name = "comments")
    private String comments = StringUtils.EMPTY;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenant_name() {
        return tenant_name;
    }

    public void setTenant_name(String tenant_name) {
        this.tenant_name = tenant_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMarried() {
        return married;
    }

    public void setMarried(int married) {
        this.married = married;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSec_mobile() {
        return sec_mobile;
    }

    public void setSec_mobile(String sec_mobile) {
        this.sec_mobile = sec_mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getBuy_intention() {
        return buy_intention;
    }

    public void setBuy_intention(int buy_intention) {
        this.buy_intention = buy_intention;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
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
