package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class GoHoContact extends GoHoObject{
    private String name = StringUtils.EMPTY;

    private String phone = StringUtils.EMPTY;

    private String mobile = StringUtils.EMPTY;

    private String sec_mobile = StringUtils.EMPTY;

    private String company = StringUtils.EMPTY;

    private String address = StringUtils.EMPTY;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
