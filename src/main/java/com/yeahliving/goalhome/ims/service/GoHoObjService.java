package com.yeahliving.goalhome.ims.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.yeahliving.goalhome.ims.bean.GoHoObjContainer;
import com.yeahliving.goalhome.ims.bean.GoHoObject;
import com.yeahliving.goalhome.ims.dao.GoHoObjMapper;
import com.yeahliving.goalhome.ims.service.response.GoHoContainerResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.ResponseMessage;
import com.yeahliving.goalhome.ims.service.response.ServiceResponse;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class GoHoObjService {

    public static GoHoObjResponse add(GoHoObject obj, Class<? extends GoHoObjMapper> mc) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        GoHoObjMapper mapper = sqlSession.getMapper(mc);
        try {
            mapper.add(obj);
            sqlSession.commit();
        } catch (Throwable throwable) {
            sqlSession.rollback();
            throwable.printStackTrace();
            throwable = ExceptionUtils.getRootCause(throwable);
            if(throwable instanceof MySQLIntegrityConstraintViolationException) {
                return new GoHoObjResponse(ServiceResponse.Status.CONSTRAINT_VIOLATION, ResponseMessage.RECORD_EXISTED, obj);
            } else {
                return new GoHoObjResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.INSERT_HOUSE_FAILED, obj);
            }
        } finally {
            sqlSession.close();
        }
        return new GoHoObjResponse(ServiceResponse.Status.OK, ResponseMessage.OK, obj);
    }

    public static GoHoContainerResponse add(GoHoObjContainer container, Class<? extends GoHoObjMapper> mc) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        GoHoObjMapper mapper = sqlSession.getMapper(mc);
        try {
            for(GoHoObject obj : container.getObj()) {
                mapper.add(obj);
            }
            sqlSession.commit();
        } catch (Throwable throwable) {
            sqlSession.rollback();
            throwable = ExceptionUtils.getRootCause(throwable);
            if(throwable instanceof MySQLIntegrityConstraintViolationException) {
                return new GoHoContainerResponse(ServiceResponse.Status.CONSTRAINT_VIOLATION, ResponseMessage.RECORD_EXISTED, container);
            } else {
                return new GoHoContainerResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.INSERT_HOUSE_FAILED, container);
            }
        } finally {
            sqlSession.close();
        }
        return new GoHoContainerResponse(ServiceResponse.Status.OK, ResponseMessage.OK, container);
    }

    public static GoHoObjResponse update(GoHoObject obj, Class<? extends GoHoObjMapper> mc) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        GoHoObjMapper mapper = sqlSession.getMapper(mc);
        try {
            mapper.update(obj);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
            return new GoHoObjResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.UPDATE_FAILED, obj);
        } finally {
            sqlSession.close();
        }
        return new GoHoObjResponse(ServiceResponse.Status.OK, ResponseMessage.OK, obj);
    }

    public static GoHoObjResponse getByID(int id, Class<? extends GoHoObjMapper> mc) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        GoHoObjMapper mapper = sqlSession.getMapper(mc);
        GoHoObject obj = null;
        try {
            obj = mapper.getByID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GoHoObjResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.SEARCH_FAILED, obj);
        } finally {
            sqlSession.close();
        }
        return new GoHoObjResponse(ServiceResponse.Status.OK, ResponseMessage.OK, obj);
    }

}
