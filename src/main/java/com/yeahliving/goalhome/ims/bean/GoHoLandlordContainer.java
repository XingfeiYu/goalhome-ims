package com.yeahliving.goalhome.ims.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class GoHoLandlordContainer {
    private List<GoHoLandlord> landlords = new ArrayList<>();

    public List<GoHoLandlord> getLandlords() {
        return landlords;
    }

    public void setLandlords(List<GoHoLandlord> landlords) {
        this.landlords = landlords;
    }
}
