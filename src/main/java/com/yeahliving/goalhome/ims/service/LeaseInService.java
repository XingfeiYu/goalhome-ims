package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoLeaseInContainer;
import com.yeahliving.goalhome.ims.bean.GoHoLeaseInSearchType;
import com.yeahliving.goalhome.ims.bean.GoHoObjContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPage;
import com.yeahliving.goalhome.ims.dao.LeaseInMapper;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;
import com.yeahliving.goalhome.ims.service.response.ResponseMessage;
import com.yeahliving.goalhome.ims.service.response.ServiceResponse;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class LeaseInService {

    public static GoHoObjResponse close(int id) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        LeaseInMapper mapper = sqlSession.getMapper(LeaseInMapper.class);
        try {
            mapper.close(id);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            ex.printStackTrace();
            return new GoHoObjResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.UPDATE_FAILED, null);
        } finally {
            sqlSession.close();
        }
        return new GoHoObjResponse(ServiceResponse.Status.OK, ResponseMessage.OK, null);
    }

//    public static GoHoSearchResponse search(GoHoLeaseInSearchType searchType, int userID, int page, int perPage) {
//        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
//        LeaseInMapper mapper = sqlSession.getMapper(LeaseInMapper.class);
//        GoHoObjContainer container = new GoHoObjContainer();
//        try {
//            switch (searchType) {
//                case MY_OPENING:
//                    container = mapper.myOpeningLease(userID);
//                    break;
//                case MY_ALL:
//                    container = mapper.myAllLease(userID);
//                    break;
//                case MY_CLOSED:
//                    container = mapper.myClosedLease(userID);
//                    break;
//                case OPENING:
//                    container = mapper.openingLease();
//                    break;
//                case ALL:
//                    container = mapper.allLease();
//                    break;
//                case CLOSED:
//                    container = mapper.closedLease();
//                    break;
//                default:
//                    container = new GoHoObjContainer();
//                    break;
//            }
//            sqlSession.commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return new GoHoSearchResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.SEARCH_FAILED, container);
//        }
//        return new GoHoSearchResponse(ServiceResponse.Status.OK, ResponseMessage.OK, container);
//    }
    public static GoHoSearchResponse search(int agent_id, int status, int pageNo, int perPage, Date from, Date to, String date_type, String dir) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        LeaseInMapper mapper = sqlSession.getMapper(LeaseInMapper.class);
        GoHoObjContainer container = new GoHoObjContainer();
        dir = StringUtils.isBlank(dir) ? "DESC" : dir;
        date_type = StringUtils.isBlank(date_type) ? "lease_start_date" : date_type;

        try {
            int count = mapper.countAll(agent_id, status, from, to, date_type);
            if(count > 0) {
                GoHoPage page = new GoHoPage(perPage, count);
                page.setPageNo(pageNo);
                if(page.getOffset() > count) {
                    return new GoHoSearchResponse(ServiceResponse.Status.BAD_REQUEST, "Wrong page number.", container);
                }
                container = mapper.all(agent_id, status, page, from, to, date_type, dir);
            }
            sqlSession.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GoHoSearchResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.SEARCH_FAILED, container);
        } finally {
            sqlSession.close();
        }
        return new GoHoSearchResponse(ServiceResponse.Status.OK,ResponseMessage.OK, container);
    }
}
