package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoRoom;
import com.yeahliving.goalhome.ims.service.RoomService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * Created by xingfeiy on 9/30/15.
 */
@Path("room")
public class RoomResource {
    @Context
    @NotNull
    private ResourceContext resourceContext;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @NotNull(message = "{room.already.exist}")
    public GoHoRoom add(
            @NotNull (message = "{room.empty.means}") @Valid
            final GoHoRoom room
    ) {
        return RoomService.add(room);
    }


}
