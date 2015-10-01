package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoAddress;
import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;
import com.yeahliving.goalhome.ims.dao.HouseMapper;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class HouseService {
    public static GoHoHouse getByID(int id) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        GoHoHouse house = null;
        try {
            house = mapper.getByID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return house;
    }

    public static GoHoHouse add(GoHoHouse house) {
        GoHoAddress address = house.getAddress();
        if(address != null) {
            AddressService.add(address);
            house.setAddress_id(address.getId());
        }

        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        try {
            mapper.add(house);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return house;
    }


    public static GoHoHouseContainer searchByStreet(String street) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        GoHoHouseContainer container = null;
        try {
            container = mapper.searchByStreet(street);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return container;
    }
}
