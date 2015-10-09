package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoLeaseIn;
import com.yeahliving.goalhome.ims.bean.GoHoLeaseInContainer;
import com.yeahliving.goalhome.ims.dao.LeaseInMapper;
import com.yeahliving.goalhome.ims.service.GoHoObjService;
import com.yeahliving.goalhome.ims.service.LeaseInService;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by xingfeiy on 10/7/15.
 */
@Path("lease_in")
public class LeaseInResource {
    @Context
    @NotNull
    private ResourceContext resourceContext;

    /**
     * Add a new lease in
     * @param leaseIn
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse add(final GoHoLeaseIn leaseIn) {
        return GoHoObjService.add(leaseIn, LeaseInMapper.class);
    }

    /**
     * Search a lease in by id.
     * @param id
     * @return
     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjResponse get(@PathParam("id") int id) {
        return GoHoObjService.getByID(id, LeaseInMapper.class);
    }

    /**
     * Update a lease in.
     * @param leaseIn
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjResponse update(final GoHoLeaseIn leaseIn) {
        return GoHoObjService.update(leaseIn, LeaseInMapper.class);
    }

    /**
     * End a lease in.
     * @param id
     * @return
     */
    @Path("close/{id}")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjResponse close(@PathParam("id") final int id) {
        return LeaseInService.close(id);
    }

    @Path("/search")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoSearchResponse search(@QueryParam("id") final int id,
                                        @QueryParam("status") final int status,
                                        @QueryParam("page") final int page,
                                        @QueryParam("per_page") final int perPage,
                                        @QueryParam("from") final long from,
                                        @QueryParam("to") final long to,
                                        @QueryParam("date_type") final String dateType,
                                        @QueryParam("dir") final String dir) {
        Date fromDate = (Float.compare(from, 0) > 0) ? new Date(from) : null;
        Date endDate = (Float.compare(to, 0) > 0) ? new Date(to) : null;
        return LeaseInService.search(id, status, page, perPage, fromDate, endDate, dateType, dir);
    }
}
