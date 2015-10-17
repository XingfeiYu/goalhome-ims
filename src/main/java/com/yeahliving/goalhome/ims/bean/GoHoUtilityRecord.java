package com.yeahliving.goalhome.ims.bean;

/**
 * Created by xingfeiy on 10/12/15.
 */
public class GoHoUtilityRecord extends GoHoObject {
    private float water = 0;

    private float gas = 0;

    private float electric = 0;

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getGas() {
        return gas;
    }

    public void setGas(float gas) {
        this.gas = gas;
    }

    public float getElectric() {
        return electric;
    }

    public void setElectric(float electric) {
        this.electric = electric;
    }

}
