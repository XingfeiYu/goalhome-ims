package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoHouseLandlord;
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

    public static int find(String identify) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        LandlordMapper mapper = sqlSession.getMapper(LandlordMapper.class);
        try {
            GoHoLandlord foundLandlord = mapper.searchByIdentify(identify);
            if(foundLandlord != null) {
                return foundLandlord.getId();
            }
        } catch (Exception ex) {
            return Integer.MIN_VALUE;
        } finally {
            sqlSession.close();
        }
        return Integer.MIN_VALUE;
    }

    public static int find(GoHoLandlord landlord) {
        return find(landlord.getIdentify());
    }

    public static boolean add(GoHoLandlord landlord, int houseID) {
        int landlordID = find(landlord);
        if(landlordID < 0) {
            add(landlord);
            landlordID = landlord.getId();
        }
        if(landlordID == Integer.MIN_VALUE){
            return false;
        }
        GoHoHouseLandlord houseLandlord = new GoHoHouseLandlord();
        houseLandlord.setLandlord_id(landlordID);
        houseLandlord.setHouse_id(houseID);
        HouseLandlordService.add(houseLandlord);
        return true;
    }
}
