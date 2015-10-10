package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Timestamp;

/**
 * Created by xingfeiy on 9/28/15.
 */
@XmlRootElement(name = "address")
public class GoHoAddress extends GoHoObject {

//    @XmlAttribute(name = "id")
//    private int id = Integer.MIN_VALUE;
    /*
    Xiao Qu name
     */
    @XmlElement(name = "complex")
    private String complex = StringUtils.EMPTY;

    @XmlElement(name = "sub_door")
    private String sub_door = StringUtils.EMPTY;

    @XmlElement(name = "door")
    private String door = StringUtils.EMPTY;

    @XmlElement(name = "street")
    private String street = StringUtils.EMPTY;

    @XmlElement(name = "district")
    private String district = StringUtils.EMPTY;

    @XmlElement(name = "city")
    private String city = StringUtils.EMPTY;

    @XmlElement(name = "province")
    private String province = StringUtils.EMPTY;

    @XmlElement(name = "postal_code")
    private String postalCode = StringUtils.EMPTY;

    @XmlElement(name = "latlon")
    private String latlon = StringUtils.EMPTY;

    @XmlElement(name = "geohash")
    private String geohash = StringUtils.EMPTY;

//    private Timestamp tstamp;

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }

//    private long id = Long.MIN_VALUE;

    public String getComplex() {
        return complex;
    }

    public void setComplex(String complex) {
        this.complex = complex;
    }

    public String getSub_door() {
        return sub_door;
    }

    public void setSub_door(String sub_door) {
        this.sub_door = sub_door;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }


    public String getLatlon() {
        return latlon;
    }

    public void setLatlon(String latlon) {
        this.latlon = latlon;
    }

//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getId() {
//        return id;
//    }

//    public Timestamp getTstamp() {
//        return tstamp;
//    }
//
//    public void setTstamp(Timestamp tstamp) {
//        this.tstamp = tstamp;
//    }

//    @Override
//    protected long getObjIdentify() {
//        if(Long.compare(this.objIdentify, 0) == 0) {
//            StringBuilder sb = new StringBuilder().append(this.sub_door).append(";").
//                    append(this.door).append(";").append(this.district).append(";").append(city);
//            this.objIdentify = HashingUtil.encodeMD5(sb.toString().trim());
//        }
//        return this.objIdentify;
//    }
}

