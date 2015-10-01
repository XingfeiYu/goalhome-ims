package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;
import com.yeahliving.goalhome.ims.dao.EmployeeLanderMapper;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by xingfeiy on 9/29/15.
 */
public class EmployeeLanderService {
    public static GoHoEmployeeLander add(GoHoEmployeeLander lander) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        EmployeeLanderMapper mapper = sqlSession.getMapper(EmployeeLanderMapper.class);
        try {
            if(mapper.getByName(lander.getUser_name()) != null) {
                return null;
            }

            mapper.add(lander);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return lander;
    }

    public static GoHoEmployeeLander getByID(int id) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        EmployeeLanderMapper mapper = sqlSession.getMapper(EmployeeLanderMapper.class);
        GoHoEmployeeLander lander = null;
        try {
            lander = mapper.getByID(id);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return lander;
    }

    public static GoHoEmployeeLander getByName(String name) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        EmployeeLanderMapper mapper = sqlSession.getMapper(EmployeeLanderMapper.class);
        GoHoEmployeeLander lander = null;
        try {
            lander = mapper.getByName(name);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return lander;
    }

//    public static List<GoHoEmployeeLander> getAll() {
//        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
//        EmployeeLanderMapper mapper = sqlSession.getMapper(EmployeeLanderMapper.class);
//    }
}
