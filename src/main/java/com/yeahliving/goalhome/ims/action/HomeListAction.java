package com.yeahliving.goalhome.ims.action;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.mvc.Viewable;

@Path("/homeList")
public class HomeListAction {

	@GET
	@Produces({ MediaType.TEXT_HTML })
	@Path("/testing")
	public Response get() {
		return Response.ok(new Viewable("/home_list")).build();
	}

}
