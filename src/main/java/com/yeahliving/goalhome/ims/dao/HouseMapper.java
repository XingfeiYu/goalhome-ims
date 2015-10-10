package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by xingfeiy on 9/28/15.
 */
public interface HouseMapper extends GoHoObjMapper {

    public GoHoHouse getByID(int id);

    public void add(GoHoHouse house);

    public GoHoHouseContainer searchByStreet(@Param("street")String street, @Param("page")GoHoPage page);

    public int countByStreet(String street);

    public GoHoHouseContainer searchAll(GoHoPage page);

    public int countAll();

    public void update(GoHoHouse house);

    public boolean delete(GoHoHouse house);
}
