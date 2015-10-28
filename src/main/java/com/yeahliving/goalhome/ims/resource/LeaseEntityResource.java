package com.yeahliving.goalhome.ims.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.yeahliving.goalhome.ims.service.LeaseUnitService;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;

/**
 * Created by xingfeiy on 10/15/15.
 */
@Path("lease_entity")
public class LeaseEntityResource {
    @Path("/list")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoSearchResponse list(@QueryParam("agent_id") final int agent_id,
                                   @QueryParam("unit_type") final int unit_type,
                                   @QueryParam("status") final int status,
                                   @QueryParam("price_range_from") final int price_range_from,
                                   @QueryParam("price_range_to") final int price_range_to,
                                   @QueryParam("page") final int page,
                                   @QueryParam("per_page") final int perPage) {
        return LeaseUnitService.list(agent_id, unit_type, status, page, perPage);
    }


}
