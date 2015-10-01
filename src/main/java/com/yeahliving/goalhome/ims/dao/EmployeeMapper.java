package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoEmployee;

/**
 * Created by xingfeiy on 9/30/15.
 */
public interface EmployeeMapper {
    public GoHoEmployee getByID(int id);

    public void add(GoHoEmployee employee);
}
