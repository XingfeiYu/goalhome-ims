package com.yeahliving.goalhome.ims.resource;

import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

/**
 * Created by xingfeiy on 10/2/15.
 */
public class LandlordTest extends ResourceTest {
    @Test
    public void testExistedLandlord() throws Exception {
        final WebTarget target = target()
                .path("landlord/find/510504198808081111");
        Response response = target
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(500, response.getStatus());
    }
}
