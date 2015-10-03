package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoLandlord;
import com.yeahliving.goalhome.ims.bean.GoHoObject;
import com.yeahliving.goalhome.ims.bean.GoHoRoom;
import com.yeahliving.goalhome.ims.constraint.GoHoObjectExisted;
import com.yeahliving.goalhome.ims.exception.DBOperateException;
import com.yeahliving.goalhome.ims.service.HouseService;
import com.yeahliving.goalhome.ims.service.LandlordService;
import com.yeahliving.goalhome.ims.service.RoomService;
import com.yeahliving.goalhome.ims.service.response.GoHoObjActiveResponse;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;

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
     * Add a new house, the basic info, landlord info and address are required.
     * @param house
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjActiveResponse add(
            @NotNull (message = "{house.empty.means}")
            @Valid final GoHoHouse house) {
        GoHoObjActiveResponse response = HouseService.add(house);
        return response;
//        return HouseService.add(house);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(
//            @NotNull (message = "{house.empty.means}")
            final GoHoHouse house) {
        if(!HouseService.update(house)) {
            return Response.status(Response.Status.NOT_MODIFIED).entity("Update failed.").
                    type(MediaType.APPLICATION_JSON).build();
        }
        return Response.ok().build();
    }

    @Path("/set/{house_id}/room")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response set(@PathParam("house_id") int houseID, final GoHoRoom room) {
        room.setHouse_id(houseID);
        RoomService.add(room);
        if(room.getId() == Integer.MIN_VALUE) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity("Can't not add room").build();
        }
        return Response.ok().build();
    }

    @Path("/set/{house_id}/landlord")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response set(@PathParam("house_id") int houseID, final GoHoLandlord landlord) {
        if(!LandlordService.add(landlord, houseID)) {
            Response.status(Response.Status.NOT_ACCEPTABLE).entity("Can't not add landlord").build();
        }
        return Response.ok().build();
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
