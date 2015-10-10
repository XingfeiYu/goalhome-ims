package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoLeaseUnit;
import com.yeahliving.goalhome.ims.dao.LeaseUnitMapper;
import com.yeahliving.goalhome.ims.service.GoHoObjService;
import com.yeahliving.goalhome.ims.service.LeaseUnitService;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by xingfeiy on 10/9/15.
 */
@Path("lease_units")
public class LeaseUnitResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse add(final GoHoLeaseUnit unit) {
        return GoHoObjService.add(unit, LeaseUnitMapper.class);
    }

    @Path("/list")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoSearchResponse list(@QueryParam("agent_id") final int agent_id,
                                   @QueryParam("unit_type") final int unit_type,
                                   @QueryParam("status") final int status,
                                   @QueryParam("page") final int page,
                                   @QueryParam("per_page") final int perPage) {
        return LeaseUnitService.list(agent_id, unit_type, status, page, perPage);
    }
}
