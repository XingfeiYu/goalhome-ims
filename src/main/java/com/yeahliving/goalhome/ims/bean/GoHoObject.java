package com.yeahliving.goalhome.ims.bean;

import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.*;

/**
 * Created by xingfeiy on 9/28/15.
 */
@MappedSuperclass
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({GoHoLeaseIn.class, GoHoAddress.class, GoHoHouse.class, GoHoHouseLandlord.class,
        GoHoLandlord.class, GoHoEmployee.class, GoHoLeaseOut.class, GoHoRoom.class,
        GoHoLeaseUnit.class, GoHoTenant.class, GoHoUtilityRecord.class, GoHoEmployeeLander.class,
        GoHoLeaseEntity.class})
public abstract class GoHoObject {

    @XmlAttribute(name = "id")
    protected int id = Integer.MIN_VALUE;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
