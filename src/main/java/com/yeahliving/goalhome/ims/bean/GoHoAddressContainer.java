package com.yeahliving.goalhome.ims.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 9/29/15.
 */
public class GoHoAddressContainer {

    private List<GoHoAddress> addresses = new ArrayList<>();

    public List<GoHoAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<GoHoAddress> addresses) {
        this.addresses = addresses;
    }
}
