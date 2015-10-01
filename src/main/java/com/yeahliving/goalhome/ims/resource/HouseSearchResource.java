package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;
import com.yeahliving.goalhome.ims.bean.GoHoHouseSearchType;
import com.yeahliving.goalhome.ims.constraint.NotEmptySearchField;
import com.yeahliving.goalhome.ims.constraint.SearchType;
import com.yeahliving.goalhome.ims.service.HouseService;
import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by xingfeiy on 9/30/15.
 */
@Produces(MediaType.APPLICATION_JSON)
public class HouseSearchResource {

    @SearchType
    @PathParam("searchType")
    private String searchType;

    @GET
    @NotNull
//    @NotEmptySearchField
    public GoHoHouseContainer searchForHouse(
            @NotBlank(message = "{search.string.empty}") @QueryParam("q") final String searchValue) {
        GoHoHouseSearchType houseSearchType = GoHoHouseSearchType.parse(searchType);
        if(houseSearchType == null) {
            return null;
        }
        GoHoHouseContainer container = null;
        switch (houseSearchType) {
            case SEARCH_BY_STREET:
                container = HouseService.searchByStreet(searchValue);
                break;
            case SEARCH_BY_CITY:
                break;
            case SEARCH_BY_DISTRICT:
                break;
            case SEARCH_BY_PROVINCE:
                break;
            default:
                break;
        }
        return container;
    }
}
