package com.yeahliving.goalhome.ims.bean;

import org.apache.commons.lang.StringUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * An entity could be a house, and this house includes multiple rooms which can be lease out individually.
 *
 * Created by xingfeiy on 10/15/15.
 */
@XmlRootElement(name = "entity")
public class GoHoLeaseEntity extends GoHoObject{

    @XmlElement(name = "unit")
    private GoHoLeaseUnit unit = new GoHoLeaseUnit();

    private GoHoObjContainer subUnits = new GoHoObjContainer();

    /**
     * The default value is the address of this entity.
     */
    private String overview = StringUtils.EMPTY;

    public GoHoLeaseUnit getUnit() {
        return unit;
    }

    public void setUnit(GoHoLeaseUnit unit) {
        this.unit = unit;
    }

    public GoHoObjContainer getSubUnits() {
        return subUnits;
    }

    public void setSubUnits(GoHoObjContainer subUnits) {
        this.subUnits = subUnits;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
