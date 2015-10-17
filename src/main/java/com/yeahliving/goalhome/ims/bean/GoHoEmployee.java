package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xingfeiy on 9/30/15.
 */
@XmlRootElement(name = "employee")
public class GoHoEmployee extends GoHoObject{
    @XmlElement(name = "employee_name")
    private String employee_name = StringUtils.EMPTY;

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

    @XmlElement(name = "job_type")
    private String job_type = StringUtils.EMPTY;

    private GoHoAddress address;

    @XmlElement(name = "address_id")
    private int address_id = Integer.MIN_VALUE;

    @XmlElement(name = "department")
    private String department = StringUtils.EMPTY;

    @XmlElement(name = "title")
    private String title = StringUtils.EMPTY;

    @XmlElement(name = "supervisor_id")
    private int supervisor_id = Integer.MIN_VALUE;

    @XmlElement(name = "pic_url")
    private String pic_url = StringUtils.EMPTY;

    @XmlElement(name = "doc_url")
    private String doc_url = StringUtils.EMPTY;

    @XmlElement(name = "comments")
    private String comments = StringUtils.EMPTY;

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
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

    public String getJob_type() {
        return job_type;
    }

    public void setJob_type(String job_type) {
        this.job_type = job_type;
    }

    public GoHoAddress getAddress() {
        return address;
    }

    public void setAddress(GoHoAddress address) {
        this.address = address;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSupervisor_id() {
        return supervisor_id;
    }

    public void setSupervisor_id(int supervisor_id) {
        this.supervisor_id = supervisor_id;
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
