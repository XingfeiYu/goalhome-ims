package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xingfeiy on 9/28/15.
 */
@XmlRootElement(name = "landlord")
public class GoHoLandlord extends GoHoObject {

    @XmlAttribute(name = "id")
    private int id = Integer.MIN_VALUE;

    @XmlElement(name = "landlord_name")
    private String landlord_name = StringUtils.EMPTY;

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

    @XmlElement(name = "job")
    private String job = StringUtils.EMPTY;

    private GoHoAddress address;

    @XmlElement(name = "address_id")
    private int address_id = Integer.MIN_VALUE;

    @XmlElement(name = "bank_account")
    private String bank_account = StringUtils.EMPTY;

    @XmlElement(name = "bank_info")
    private String bank_info = StringUtils.EMPTY;

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

    public String getLandlord_name() {
        return landlord_name;
    }

    public void setLandlord_name(String landlord_name) {
        this.landlord_name = landlord_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMarried() {
        return married == 1;
    }

    public void setMarried(boolean married) {
        this.married = married ? 1 : 0;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

//    public Gender getGender() {
//        switch (this.gender) {
//            case 0:
//                return Gender.FEMALE;
//            case 1:
//                return Gender.MALE;
//            default:
//                return Gender.UNKNOWN;
//        }
//    }
//
//    public void setGender(Gender gender) {
//        switch (gender) {
//            case FEMALE:
//                this.gender = 0;
//                break;
//            case MALE:
//                this.gender = 1;
//                break;
//            default:
//                this.gender = 2;
//                break;
//        }
//    }


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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
    }

    public String getBank_info() {
        return bank_info;
    }

    public void setBank_info(String bank_info) {
        this.bank_info = bank_info;
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

    public GoHoAddress getAddress() {
        return address;
    }

    public void setAddress(GoHoAddress address) {
        this.address = address;
    }
}
