package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoHouseLandlord;
import com.yeahliving.goalhome.ims.bean.GoHoLandlord;
import com.yeahliving.goalhome.ims.bean.GoHoObject;
import com.yeahliving.goalhome.ims.bean.GoHoRoom;
import com.yeahliving.goalhome.ims.constraint.SearchType;
import com.yeahliving.goalhome.ims.service.HouseLandlordService;
import com.yeahliving.goalhome.ims.service.LandlordService;
import com.yeahliving.goalhome.ims.service.RoomService;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by xingfeiy on 10/1/15.
 */
public class HouseSettingResource {
    public enum SetContent {
        LANDLORD,

        ROOM;
    }

    @SearchType
    @PathParam("content")
    private String content;

    @PathParam("house_id")
    private int houseID;

    @GET
    @NotNull
    public Response set(final GoHoObject object) {
        if(StringUtils.equalsIgnoreCase(SetContent.LANDLORD.name(), content) &&
                object instanceof GoHoLandlord) {
            GoHoLandlord landlord = (GoHoLandlord)object;
            LandlordService.add(landlord);
            int landlordID = landlord.getId();
            if(landlordID == Integer.MIN_VALUE) {
                return Response.status(Response.Status.NOT_IMPLEMENTED).
                        entity("Can't insert object landlord into database.").build();
            }
            GoHoHouseLandlord houseLandlord = new GoHoHouseLandlord();
            houseLandlord.setLandlord_id(landlordID);
            houseLandlord.setHouse_id(houseID);
            HouseLandlordService.add(houseLandlord);
        } else if (StringUtils.equalsIgnoreCase(SetContent.ROOM.name(), content) &&
                object instanceof GoHoRoom) {
            GoHoRoom room = (GoHoRoom) object;
            room.setHouse_id(houseID);
            RoomService.add(room);
        }

        return Response.ok().build();
    }
}
