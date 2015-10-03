package com.yeahliving.goalhome.ims.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;
import com.yeahliving.goalhome.ims.dao.HouseMapper;
import com.yeahliving.goalhome.ims.exception.DBOperateException;
import com.yeahliving.goalhome.ims.exception.ExceptionMessage;
import com.yeahliving.goalhome.ims.service.response.GoHoObjActiveResponse;
import com.yeahliving.goalhome.ims.service.response.ResponseMessage;
import com.yeahliving.goalhome.ims.service.response.ServiceResponse;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.reflection.ExceptionUtil;
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

    public static boolean update(GoHoHouse house) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        try {
            mapper.update(house);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return true;
    }

    /**
     * Address and Landlord are required for a House object.
     * @param house
     * @return
     */
    public static GoHoObjActiveResponse add(GoHoHouse house) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        try {
            mapper.add(house);
            sqlSession.commit();
        } catch (Throwable throwable) {
            sqlSession.rollback();
            throwable = ExceptionUtils.getRootCause(throwable);
            if(throwable instanceof MySQLIntegrityConstraintViolationException) {
                return new GoHoObjActiveResponse(ServiceResponse.Status.CONSTRAINT_VIOLATION, ResponseMessage.ADDRESS_EXISTED);
            } else {
                return new GoHoObjActiveResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.INSERT_HOUSE_FAILED);
            }
        } finally {
            sqlSession.close();
        }
        GoHoObjActiveResponse response = new GoHoObjActiveResponse(ServiceResponse.Status.OK, ResponseMessage.OK);
        response.setObject(house);
        return response;
    }

//    public static Integer add(GoHoHouse house) {
//        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
//        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
//        try {
//            mapper.add(house);
//            sqlSession.commit();
//        } catch (Throwable throwable) {
//            sqlSession.rollback();
//            throwable = ExceptionUtils.getRootCause(throwable);
//            if(throwable instanceof MySQLIntegrityConstraintViolationException) {
//                return ServiceResponse.Status.CONSTRAINT_VIOLATION.getCode();
//            } else {
//                return null;
//            }
//        }
//        finally {
//            sqlSession.close();
//        }
//        return house.getID();
//    }


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
