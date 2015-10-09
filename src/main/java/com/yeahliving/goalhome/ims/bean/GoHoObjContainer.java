package com.yeahliving.goalhome.ims.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingfeiy on 10/8/15.
 */
public class GoHoObjContainer {
    private List<? extends GoHoObject> obj = new ArrayList<>();

    public List<? extends GoHoObject> getObj() {
        return obj;
    }

    public void setObj(List<? extends GoHoObject> obj) {
        this.obj = obj;
    }
}
