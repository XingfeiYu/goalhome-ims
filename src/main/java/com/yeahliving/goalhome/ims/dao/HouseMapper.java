package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;

import java.util.List;

/**
 * Created by xingfeiy on 9/28/15.
 */
public interface HouseMapper {

    public GoHoHouse getByID(int id);

    public void add(GoHoHouse house);

    public GoHoHouseContainer searchByStreet(String street);

    public List<GoHoHouse> getAll();

    public GoHoHouse update(GoHoHouse house);

    public boolean delete(GoHoHouse house);
}
