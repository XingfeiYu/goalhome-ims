package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoHouseLandlord;
import com.yeahliving.goalhome.ims.dao.HouseLandlordMapper;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xingfeiy on 10/1/15.
 */
public class HouseLandlordService {
    public static GoHoHouseLandlord add(GoHoHouseLandlord houseLandlord) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        HouseLandlordMapper mapper = sqlSession.getMapper(HouseLandlordMapper.class);
        try {
            mapper.add(houseLandlord);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return houseLandlord;
    }
}
