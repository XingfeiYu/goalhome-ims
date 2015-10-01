package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoLandlord;
import com.yeahliving.goalhome.ims.service.LandlordService;

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
@Path("landlord")
public class LandlordResource {
    @Context
    @NotNull
    private ResourceContext resourceContext;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @NotNull(message = "{landlord.already.exist}")
    public GoHoLandlord add(
            @NotNull (message = "{landlord.empty.means}") @Valid
            final GoHoLandlord landlord
    ) {
        return LandlordService.add(landlord);
    }
}
