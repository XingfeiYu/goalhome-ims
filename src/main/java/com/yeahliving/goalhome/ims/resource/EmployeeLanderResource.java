package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;
import com.yeahliving.goalhome.ims.constraint.HasEmployeeName;
import com.yeahliving.goalhome.ims.dao.EmployeeLanderMapper;
import com.yeahliving.goalhome.ims.service.EmployeeLanderService;
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
@Path("emp_login")
public class EmployeeLanderResource {
//    private SqlSession sqlSession = DBUtils.getSessionFactory().openSession();

//    private EmployeeLanderMapper mapper = sqlSession.getMapper(EmployeeLanderMapper.class);

    @Context
    Request request;

    @Context
    @NotNull
    private ResourceContext resourceContext;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @NotNull(message = "{lander.already.exist}")
    @HasEmployeeName
    public GoHoEmployeeLander add(
            @NotNull (message = "{lander.empty.means}") @Valid
            final GoHoEmployeeLander lander) {
        return EmployeeLanderService.add(lander);
    }


    @Path("/{id}")
    @GET
    @NotNull(message = "{contact.does.not.exist}")
    @Produces(MediaType.APPLICATION_JSON)
    public GoHoEmployeeLander getByID(@PathParam("id") int id) {
        return EmployeeLanderService.getByID(id);
    }
}
