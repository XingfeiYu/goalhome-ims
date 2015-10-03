package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoRoom;
import com.yeahliving.goalhome.ims.dao.RoomMapper;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class RoomService {

    public static GoHoRoom add(GoHoRoom room) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        RoomMapper mapper = sqlSession.getMapper(RoomMapper.class);
        try {
            mapper.add(room);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return room;
    }

}
