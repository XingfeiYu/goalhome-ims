package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoTenant;

/**
 * Created by xingfeiy on 9/30/15.
 */
public interface TenantMapper {
    public GoHoTenant getByID(int id);

    public void add(GoHoTenant tenant);
}
