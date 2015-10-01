package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;
import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.constraint.HasEmployeeName;
import com.yeahliving.goalhome.ims.dao.HouseMapper;
import com.yeahliving.goalhome.ims.service.EmployeeLanderService;
import com.yeahliving.goalhome.ims.service.HouseService;
import com.yeahliving.goalhome.ims.utils.DBUtils;
import org.apache.ibatis.session.SqlSession;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;

/**
 * Created by xingfeiy on 9/28/15.
 */
@Path("house")
public class HouseResource {

    @Context
    @NotNull
    private ResourceContext resourceContext;

    @Context
    Request request;

    /**
     * Add a new house, the basic info and address are required.
     * @param house
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @NotNull(message = "{house.already.exist}")
//    @HasEmployeeName
    public GoHoHouse add(
            @NotNull (message = "{house.empty.means}") @Valid
            final GoHoHouse house) {
        return HouseService.add(house);
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoHouse getByID(@PathParam("id") int id) {
       return HouseService.getByID(id);
    }

    @Path("search/{searchType}")
    public HouseSearchResource search() {
        return resourceContext.getResource(HouseSearchResource.class);
    }
}
