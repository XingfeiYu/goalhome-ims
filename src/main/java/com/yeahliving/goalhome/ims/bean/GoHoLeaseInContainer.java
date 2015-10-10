package com.yeahliving.goalhome.ims.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class GoHoLeaseInContainer {
    private List<GoHoLeaseIn> leaseIns = new ArrayList<>();

    public List<GoHoLeaseIn> getLeaseIns() {
        return leaseIns;
    }

    public void setLeaseIns(List<GoHoLeaseIn> leaseIns) {
        this.leaseIns = leaseIns;
    }
}
