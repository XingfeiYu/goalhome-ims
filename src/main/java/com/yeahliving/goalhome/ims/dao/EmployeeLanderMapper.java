package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;

/**
 * Created by xingfeiy on 9/28/15.
 */
public interface EmployeeLanderMapper {

    public GoHoEmployeeLander getByID(int id);

    public GoHoEmployeeLander getByName(String user_name);

    public void add(GoHoEmployeeLander lander);
}
