package com.yeahliving.goalhome.ims.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by xingfeiy on 9/25/15.
 */
@Path("/test")
public class HelloWorldResource {
    public static final String CLICHED_MESSAGE = "Hello World!";

    @Path("/hi")
    @GET
    @Produces("text/plain")
    public String getHello() {
        return CLICHED_MESSAGE;
    }
}
