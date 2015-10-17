package com.yeahliving.goalhome.ims.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.yeahliving.goalhome.ims.bean.*;
import com.yeahliving.goalhome.ims.dao.HouseMapper;
import com.yeahliving.goalhome.ims.service.response.GoHoHouseResponse;
import com.yeahliving.goalhome.ims.service.response.ResponseMessage;
import com.yeahliving.goalhome.ims.service.response.ServiceResponse;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
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
    public static GoHoHouseResponse add(GoHoHouse house) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        try {
            mapper.add(house);
            sqlSession.commit();
        } catch (Throwable throwable) {
            sqlSession.rollback();
            throwable = ExceptionUtils.getRootCause(throwable);
            if(throwable instanceof MySQLIntegrityConstraintViolationException) {
                return new GoHoHouseResponse(ServiceResponse.Status.CONSTRAINT_VIOLATION, ResponseMessage.ADDRESS_EXISTED);
            } else {
                return new GoHoHouseResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.INSERT_HOUSE_FAILED);
            }
        } finally {
            sqlSession.close();
        }
        GoHoHouseResponse response = new GoHoHouseResponse(ServiceResponse.Status.OK, ResponseMessage.OK);
        response.setObject(house);
        return response;
    }

    public static GoHoAddress getAddress(int houseID) {
        GoHoHouse house = getByID(houseID);
        return house != null ? house.getAddress() : null;
    }

    public static GoHoHouseContainer search(GoHoHouseSearchType searchType, String searchValue, int pageNo, int perPage) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseMapper mapper = sqlSession.getMapper(HouseMapper.class);
        GoHoHouseContainer container = null;
        int count = 0;
        GoHoPage page = new GoHoPage();
        try {
            switch (searchType) {
                case ALL:
                    count = mapper.countAll();
                    page = new GoHoPage(perPage, count);
                    page.setPageNo(pageNo);
                    container = mapper.searchAll(page);
                    break;
                case SEARCH_BY_STREET:
                    count = mapper.countAll();
                    page = new GoHoPage(perPage, count);
                    page.setPageNo(pageNo);
                    container = mapper.searchByStreet(searchValue, page);

                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return container;
    }
}
