package com.yeahliving.goalhome.ims.service;

import com.yeahliving.goalhome.ims.bean.GoHoObjContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPage;
import com.yeahliving.goalhome.ims.dao.LeaseUnitMapper;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;
import com.yeahliving.goalhome.ims.service.response.ResponseMessage;
import com.yeahliving.goalhome.ims.service.response.ServiceResponse;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by xingfeiy on 10/9/15.
 */
public class LeaseUnitService {

    public static GoHoSearchResponse list(int uid, int unit_type, int status, int pageNo, int perPage) {
        SqlSession sqlSession = DBUtils.getSessionFactory().openSession();
        LeaseUnitMapper mapper = sqlSession.getMapper(LeaseUnitMapper.class);
        GoHoObjContainer container = new GoHoObjContainer();
        try {
            int count = mapper.countAll(uid, unit_type, status);
            if(count > 0) {
                GoHoPage page = new GoHoPage(perPage, count);
                page.setPageNo(pageNo);
                if(page.getOffset() > count) {
                    return new GoHoSearchResponse(ServiceResponse.Status.BAD_REQUEST, "Wrong page number.", container);
                }
                container = mapper.all(uid, unit_type, status, page);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return new GoHoSearchResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.SEARCH_FAILED, container);
        } finally {
            sqlSession.close();
        }
        return new GoHoSearchResponse(ServiceResponse.Status.OK,ResponseMessage.OK, container);
    }

}
