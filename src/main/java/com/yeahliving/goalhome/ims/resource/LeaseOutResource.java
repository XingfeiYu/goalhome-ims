package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoLeaseOut;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.Response;

/**
 * Created by xingfeiy on 10/9/15.
 */
@Path("lease_out")
public class LeaseOutResource {
    @Path("{lease_unit_id}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(final GoHoLeaseOut leaseOut) {
        return null;
    }
}
