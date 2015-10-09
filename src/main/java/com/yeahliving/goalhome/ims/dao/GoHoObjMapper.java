package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoObject;

/**
 * Created by xingfeiy on 10/7/15.
 */
public interface GoHoObjMapper {

    public void add(GoHoObject obj);

    public void update(GoHoObject obj);

    public GoHoObject getByID(int id);

}
