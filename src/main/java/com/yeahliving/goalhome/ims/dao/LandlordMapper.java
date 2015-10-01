package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoLandlord;
import com.yeahliving.goalhome.ims.bean.GoHoLandlordContainer;

/**
 * Created by xingfeiy on 9/30/15.
 */
public interface LandlordMapper {
    public GoHoLandlord getByID(int id);

    public void add(GoHoLandlord landlord);

    public GoHoLandlordContainer getAll();

    public GoHoLandlordContainer searchByName(String name);

    public GoHoLandlordContainer searchByStreet(String street);

    public GoHoLandlordContainer searchByDistrict(String district);
}
