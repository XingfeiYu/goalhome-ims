package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoAddress;
import com.yeahliving.goalhome.ims.bean.GoHoAddressContainer;
import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;
import com.yeahliving.goalhome.ims.dao.AddressMapper;
import com.yeahliving.goalhome.ims.dao.EmployeeLanderMapper;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;


/**
 * Created by xingfeiy on 9/29/15.
 */
public class AddressService {
    public static GoHoAddress add(GoHoAddress address) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        try {
            mapper.add(address);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return address;
    }

    public static GoHoAddress getByID(int id) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        GoHoAddress address = null;
        try {
            address = mapper.getByID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return address;
    }

    public static GoHoAddressContainer searchAddressByStreet(String street) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        AddressMapper mapper = sqlSession.getMapper(AddressMapper.class);
        GoHoAddressContainer container = null;
        try {
            container = mapper.searchByStreet(street);
//            List<GoHoAddress> address = mapper.searchByStreet(street);
//            if(address == null) {}
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return container;
    }
}
