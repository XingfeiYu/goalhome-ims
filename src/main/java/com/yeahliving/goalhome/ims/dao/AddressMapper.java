package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoAddress;
import com.yeahliving.goalhome.ims.bean.GoHoAddressContainer;

import java.util.List;

/**
 * Created by xingfeiy on 9/29/15.
 */
public interface AddressMapper {

    public GoHoAddress getByID(int id);

    public void add(GoHoAddress address);

    public void delete(int id);

    public GoHoAddressContainer searchByStreet(String street);
//    public List<GoHoAddress> searchByStreet(String street);

    public GoHoAddressContainer searchByCity(String city);

    public GoHoAddressContainer searchByDistrict(String district);

    public GoHoAddressContainer searchByComplex(String complex);
}
