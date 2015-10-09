package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoLeaseInSearchType;
import com.yeahliving.goalhome.ims.constraint.SearchType;
import com.yeahliving.goalhome.ims.service.LeaseInService;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;
import com.yeahliving.goalhome.ims.service.response.GoHoSearchResponse;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * Created by xingfeiy on 10/8/15.
 */
@Produces(MediaType.APPLICATION_JSON)
public class LeaseInSearchResource {
//    @SearchType
    @PathParam("searchType")
    private String searchType;

    @GET
    @NotNull
    public GoHoSearchResponse search(
//            @NotBlank(message = "{search.string.empty}")
            @QueryParam("id") final int id,
            @QueryParam("status") final int status,
            @QueryParam("page") final int page,
            @QueryParam("per_page") final int perPage,
            @QueryParam("from") final long from,
            @QueryParam("to") final long to,
            @QueryParam("date_type") final String dateType,
            @QueryParam("dir") final String dir) {
        Date fromDate = (Float.compare(from, 0) > 0) ? new Date(from) : null;
        Date endDate = (Float.compare(to, 0) > 0) ? new Date(to) : null;
        return LeaseInService.search(id, status,page, perPage, fromDate, endDate, dateType, dir);
    }

//    @Path("/")
//    @GET
//    @NotNull
//    public GoHoSearchResponse searchPeriod(
////            @NotBlank(message = "{search.string.empty}")
//            @QueryParam("id") final int id,
//            @QueryParam("page") final int page,
//            @QueryParam("per_page") final int perPage) {
//        GoHoLeaseInSearchType leaseInSearchType = GoHoLeaseInSearchType.parse(searchType);
//        if(leaseInSearchType == null) {}
//        return LeaseInService.search(leaseInSearchType, id, page, perPage);
//    }

}
