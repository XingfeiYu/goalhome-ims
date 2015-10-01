package com.yeahliving.goalhome.ims.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class GoHoHouseContainer {
    private List<GoHoHouse> houses = new ArrayList<>();

    public List<GoHoHouse> getHouses() {
        return houses;
    }

    public void setHouses(List<GoHoHouse> houses) {
        this.houses = houses;
    }
}
