package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.*;
import com.yeahliving.goalhome.ims.dao.*;
import com.yeahliving.goalhome.ims.service.*;
import com.yeahliving.goalhome.ims.service.response.*;

import javax.validation.Valid;
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
     * The first step of lease in is add a house, it's the only way to add a new house.
     * We can get a house id after added it successfully.
     * @param house
     * @return
     */
    @Path("house")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse add(
            @NotNull (message = "{house.empty.means}")
            @Valid final GoHoHouse house) {
        return GoHoObjService.add(house, HouseMapper.class);
    }

    /**
     * The next step, we are going to add landlord info for the added house.
     * The house can be status "leasable" only the landlord info is added.
     * @param houseID
     * @param landlord
     * @return
     */
    @Path("house/landlord")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjResponse set(@QueryParam("house_id") int houseID,
                        final GoHoLandlord landlord) {
        GoHoObjResponse response = GoHoObjService.add(landlord, LandlordMapper.class);
        if(ServiceResponse.Status.OK.equals(response.getStatus())) {
            GoHoHouseLandlord houseLandlord = new GoHoHouseLandlord();
            houseLandlord.setLandlord_id(landlord.getId());
            houseLandlord.setHouse_id(houseID);
            HouseLandlordService.add(houseLandlord);
        }
        return response;
    }

    /**
     * Next, let's add rooms info for the added house.
     * @param houseID
     * @param rooms
     * @return
     */
    @Path("house/room")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoContainerResponse set(@QueryParam("house_id") int houseID,
                        final GoHoObjContainer rooms) {
        GoHoContainerResponse response = GoHoObjService.add(rooms, RoomMapper.class);
        if(ServiceResponse.Status.OK.equals(response.getStatus())) {
            for(GoHoObject room : rooms.getObj()) {
                ((GoHoRoom) room).setHouse_id(houseID);
            }
        }
        return response;
    }

    /**
     * If the vendor of house is available, add it.
     * @param houseID
     * @param vendor
     * @return
     */
    @Path("house/vendor")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjResponse setVendor(@QueryParam("house_id") int houseID,
                                     final GoHoHouseVendor vendor) {
        return GoHoObjService.add(vendor, HouseVendorMapper.class);
    }

//    /**
//     * add comment if needed.
//     * @param houseID
//     * @param comment
//     * @return
//     */
//    @Path("house/{house_id}/comment")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public GoHoObjResponse addHouseComment(@PathParam("house_id") int houseID,
//                                           final GoHoComment comment) {
//        return GoHoObjService.add(comment, CommentMapper.class);
//    }

    /**
     * Last step, input some basic info about the whole lease and finish it.
     * @return
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoHoObjResponse add(final GoHoRichLeaseIn request) {
        return LeaseInService.add(request);
    }

//    /**
//     * add comment if needed.
//     * @param lease_in_id
//     * @param comment
//     * @return
//     */
//    @Path("{lease_in_id}/comment")
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public GoHoObjResponse addLeaseInComment(@PathParam("lease_in_id") int lease_in_id,
//                                             final GoHoComment comment) {
//        return GoHoObjService.add(comment, CommentMapper.class);
//    }

    /**
     * Search a lease in by id.
     * @param id
     * @return
     */
    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoObjResponse get(@PathParam("id") int id) {
        GoHoObjResponse objResponse = GoHoObjService.getByID(id, LeaseInMapper.class);
        if(!ServiceResponse.Status.OK.equals(objResponse.getStatus())) {
            return new GoHoObjResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.SEARCH_FAILED, null);
        }
        GoHoLeaseIn leaseIn = (GoHoLeaseIn)objResponse.getGoHoObj();
        //get house
        objResponse = GoHoObjService.getByID(leaseIn.getHouse_id(), HouseMapper.class);
        if(!ServiceResponse.Status.OK.equals(objResponse.getStatus())) {
            return new GoHoObjResponse(ServiceResponse.Status.DB_FAILED, ResponseMessage.SEARCH_FAILED, null);
        }
        GoHoHouse house = (GoHoHouse)objResponse.getGoHoObj();

        GoHoRichLeaseIn richLeaseIn = new GoHoRichLeaseIn();
        richLeaseIn.setHouse(house);
        richLeaseIn.setLandlord(house.getLandlord());
        richLeaseIn.setRoomContainer(house.getRooms());

        return new GoHoObjResponse(ServiceResponse.Status.OK, ResponseMessage.OK, richLeaseIn);
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

    @Path("/list")
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoSearchResponse list(@QueryParam("id") final int id,
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
