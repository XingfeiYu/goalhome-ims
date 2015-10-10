package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoObjContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPage;
import org.apache.ibatis.annotations.Param;

/**
 * Created by xingfeiy on 10/9/15.
 */
public interface LeaseUnitMapper extends GoHoObjMapper {

    public int countAll(@Param("agent_id") int agent_id, @Param("unit_type") int unit_type, @Param("status")int status);

    public GoHoObjContainer all(@Param("agent_id") int uid, @Param("unit_type") int unit_type,
                                @Param("status")int status, @Param("page") GoHoPage page);
}
