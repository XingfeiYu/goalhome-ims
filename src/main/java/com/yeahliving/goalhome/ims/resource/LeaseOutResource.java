package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoLeaseOut;
import com.yeahliving.goalhome.ims.bean.GoHoTenant;
import com.yeahliving.goalhome.ims.bean.GoHoUtilityRecord;
import com.yeahliving.goalhome.ims.dao.LeaseOutMapper;
import com.yeahliving.goalhome.ims.dao.TenantMapper;
import com.yeahliving.goalhome.ims.dao.UtilityRecordMapper;
import com.yeahliving.goalhome.ims.service.GoHoObjService;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

/**
 * Created by xingfeiy on 10/9/15.
 */
@Path("lease_out")
public class LeaseOutResource {
    /**
     * For lease out, the first step is fill the tenant info, the lease out is invalid without tenant info.
     * @param tenant
     * @return
     */
    @Path("/tenant")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse addTenant(final GoHoTenant tenant) {
        return GoHoObjService.add(tenant, TenantMapper.class);
    }

    /**
     * Add start utility record is required.
     * @param utilityRecord
     * @return
     */
    @Path("start_utility")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse addStartUtilityRecord(final GoHoUtilityRecord utilityRecord) {
        return GoHoObjService.add(utilityRecord, UtilityRecordMapper.class);
    }

    /**
     * The tenant id is required for a lease out event, you can select a existed tenant in database, or add new one.
     * @param lease_unit_id
     * @param leaseOut
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse add(@QueryParam("lease_unit_id") int lease_unit_id,
                        final GoHoLeaseOut leaseOut) {
        return GoHoObjService.add(leaseOut, LeaseOutMapper.class);
    }


    /**
     * End a lease out, add utility record is also required.
     * @param lease_unit_id
     * @param utilityRecord
     * @return
     */
    @Path("end_utility")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse end(@QueryParam("lease_id") int lease_unit_id,
                                          final GoHoUtilityRecord utilityRecord) {
        return GoHoObjService.add(utilityRecord, UtilityRecordMapper.class);
    }

}
