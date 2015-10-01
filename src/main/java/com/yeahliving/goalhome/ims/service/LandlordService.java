package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoLandlord;
import com.yeahliving.goalhome.ims.dao.LandlordMapper;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class LandlordService {
    public static GoHoLandlord add(GoHoLandlord landlord) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        LandlordMapper mapper = sqlSession.getMapper(LandlordMapper.class);
        try {
            mapper.add(landlord);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return landlord;
    }
}
