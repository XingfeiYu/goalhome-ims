package com.yeahliving.goalhome.ims.bean;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * Created by xingfeiy on 9/28/15.
 */
@MappedSuperclass
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({GoHoLeaseIn.class,GoHoAddress.class, GoHoHouse.class, GoHoHouseLandlord.class,
        GoHoLandlord.class, GoHoEmployee.class, GoHoLeaseOut.class, GoHoRoom.class, GoHoLeaseUnit.class})
public class GoHoObject {

}
