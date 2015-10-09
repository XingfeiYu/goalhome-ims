package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoObjContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by xingfeiy on 10/7/15.
 */
public interface LeaseInMapper extends GoHoObjMapper {

    public void close(int id);

    public int countAll(@Param("agent_id") int agent_id, @Param("status")int status,@Param("from_date")Date from, @Param("end_date")Date to,
                        @Param("date_type")String date_type);

    public GoHoObjContainer all(@Param("agent_id") int agent_id, @Param("status")int status, @Param("page") GoHoPage page,
                                @Param("from_date")Date from, @Param("end_date")Date to,
                                @Param("date_type")String date_type, @Param("dir")String dir);

}
