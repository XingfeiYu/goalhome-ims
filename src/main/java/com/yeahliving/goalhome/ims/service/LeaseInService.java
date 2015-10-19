package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.*;
import com.yeahliving.goalhome.ims.dao.*;
import com.yeahliving.goalhome.ims.service.response.*;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

/**
 * Created by xingfeiy on 10/7/15.
 */
public class LeaseInService {

    public static GoHoObjResponse add(GoHoRichLeaseIn leaseInRequest) {
        if(leaseInRequest == null || leaseInRequest.getHouse() == null || leaseInRequest.getLeaseIn() == null) {
            return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
        }

        GoHoObjResponse response;
        if(leaseInRequest.getLandlord() != null) {
            response = GoHoObjService.add(leaseInRequest.getLandlord(), LandlordMapper.class);
            if(!ServiceResponse.Status.OK.equals(response.getStatus())) {
                return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
            }
            int landlordId = response.getGoHoObj().getId();
            leaseInRequest.getHouse().setLandlord_id(landlordId);
        }

        response = GoHoObjService.add(leaseInRequest.getHouse(), HouseMapper.class);
        if(!ServiceResponse.Status.OK.equals(response.getStatus())) {
            return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
        }
        int houseId = response.getGoHoObj().getId();

        //Add the house into lease unit repository.
        GoHoLeaseUnit leaseUnit = new GoHoLeaseUnit();
        leaseUnit.setHouse_id(houseId);
        leaseUnit.setEntity_id(houseId);
        leaseUnit.setUnit_type(1);
        leaseUnit.setAgent_id(leaseInRequest.getLeaseIn().getAgent_id());
        response = GoHoObjService.add(leaseUnit, LeaseUnitMapper.class);
        if(!ServiceResponse.Status.OK.equals(response.getStatus())) {
            return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
        }

        if(leaseInRequest.getRoomContainer() != null) {
            for(GoHoObject obj : leaseInRequest.getRoomContainer().getObj()) {
                ((GoHoRoom)obj).setHouse_id(houseId);
            }

            GoHoContainerResponse containerResponse = GoHoObjService.add(leaseInRequest.getRoomContainer(), RoomMapper.class);
            if(!ServiceResponse.Status.OK.equals(containerResponse.getStatus())) {
                return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
            }

            //Add all rooms into lease unit repository.
            for(GoHoObject obj : leaseInRequest.getRoomContainer().getObj()) {
                GoHoRoom room = (GoHoRoom)obj;
                GoHoLeaseUnit roomUnit = new GoHoLeaseUnit();
                roomUnit.setHouse_id(houseId);
                roomUnit.setEntity_id(room.getId());
                roomUnit.setUnit_type(0);
                roomUnit.setAgent_id(leaseInRequest.getLeaseIn().getAgent_id());
                response = GoHoObjService.add(roomUnit, LeaseUnitMapper.class);
                if(!ServiceResponse.Status.OK.equals(response.getStatus())) {
                    return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
                }
            }
        }

        leaseInRequest.getLeaseIn().setHouse_id(houseId);
        response = GoHoObjService.add(leaseInRequest.getLeaseIn(), LeaseInMapper.class);
        if(!ServiceResponse.Status.OK.equals(response.getStatus())) {
            return new GoHoObjResponse(ServiceResponse.Status.ADD_ERROR, ResponseMessage.INSERT_FAILED, null);
        }
        return response;
    }

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
