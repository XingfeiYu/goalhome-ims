package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class GoHoHouseWatcher extends GoHoObject{

    private int house_id = Integer.MIN_VALUE;

    private int agent_id = Integer.MIN_VALUE;

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
    }
}
