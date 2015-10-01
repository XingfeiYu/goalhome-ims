package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.ServiceApplication;
import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;
import com.yeahliving.goalhome.ims.bean.GoHoHouse;
import com.yeahliving.goalhome.ims.bean.GoHoHouseContainer;
import com.yeahliving.goalhome.ims.bean.GoHoPropertyStatus;
import com.yeahliving.goalhome.ims.service.AddressServiceTest;
import org.eclipse.persistence.jaxb.BeanValidationMode;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.validation.ValidationError;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.external.ExternalTestContainerFactory;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by xingfeiy on 9/30/15.
 */
public class HouseTest extends JerseyTest {
    private static final GoHoHouse house_1;
    private static final GoHoHouse house_2;
    private static final GoHoHouse house_3;
    private static final GoHoHouse house_4;

    static {
        house_1 = new GoHoHouse();
        house_1.setAddress(AddressServiceTest.address);
        house_1.setAddress_id(1);
        house_1.setAlias("9");
        house_1.setHouse_type("两室一厅");
        house_1.setArea(100);
//        house_1.setRoom_ids("101,102,103");
//        house_1.setAgent_id(18);
        house_1.setStatus(GoHoPropertyStatus.PENDING.name());
        house_1.setFor_sell(false);
//        house_1.setLandlord_id(123);
        house_1.setComments("空姐邻居");

        house_2 = new GoHoHouse();
        house_2.setAddress(AddressServiceTest.address1);
        house_2.setAlias("88");
        house_2.setHouse_type("两室一厅");
        house_2.setArea(160);
//        house_2.setRoom_ids("101,102,103");
//        house_2.setAgent_id(1);
        house_2.setStatus(GoHoPropertyStatus.PENDING.name());
        house_2.setFor_sell(false);
//        house_2.setLandlord_id(123);
        house_2.setComments("隔壁公安局");

        house_3 = new GoHoHouse();
        house_3.setAddress(AddressServiceTest.address2);
        house_3.setAlias("888");
        house_3.setHouse_type("两室两厅");
        house_3.setArea(90);
//        house_3.setRoom_ids("101,102,103");
//        house_3.setAgent_id(1);
        house_3.setStatus(GoHoPropertyStatus.LEASING.name());
        house_3.setFor_sell(false);
//        house_3.setLandlord_id(123);
        house_3.setComments("隔壁公安局");

        house_4 = new GoHoHouse();
        house_4.setAddress(AddressServiceTest.address3);
        house_4.setAlias("8888");
        house_4.setHouse_type("两室一厅");
        house_4.setArea(1000);
//        house_4.setRoom_ids("1,2,3");
//        house_4.setAgent_id(1);
        house_4.setStatus(GoHoPropertyStatus.DECORATING.name());
        house_4.setFor_sell(true);
//        house_4.setLandlord_id(123);
        house_4.setComments("隔壁公安局");
    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        return new ServiceApplication().property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }

    @Override
    protected void configureClient(final ClientConfig config) {
        super.configureClient(config);

        config.register(MoxyJsonFeature.class);
        // Turn off BV otherwise the entities on client would be validated as well.
        config.register(new MoxyJsonConfig()
                .property(MarshallerProperties.BEAN_VALIDATION_MODE, BeanValidationMode.NONE)
                .resolver());
    }

    @Override
    protected URI getBaseUri() {
        final UriBuilder baseUriBuilder = UriBuilder.fromUri(super.getBaseUri()).path("goalhome-ims");
        final boolean externalFactoryInUse = getTestContainerFactory() instanceof ExternalTestContainerFactory;
        return externalFactoryInUse ? baseUriBuilder.path("api").build() : baseUriBuilder.build();
    }

    @Test
    public void testAddHouse() throws Exception {
        final WebTarget target = target()
                .path("house");
        final Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(house_1, MediaType.APPLICATION_JSON_TYPE));

        final GoHoHouse house = response.readEntity(GoHoHouse.class);

        assertEquals(200, response.getStatus());
        assertNotNull(house.getID());

//        final Response invalidResponse = target.request(MediaType.APPLICATION_JSON_TYPE)
//                .post(Entity.entity(house_1, MediaType.APPLICATION_JSON_TYPE));
//        assertEquals(500, invalidResponse.getStatus());
//        assertTrue(getValidationMessageTemplates(invalidResponse).contains("{house.already.exist}"));

//        assertEquals(200, target.path("" + lander.getId()).request(MediaType.APPLICATION_JSON_TYPE).delete().getGohoStatus());
    }

    @Test
    public void testGetHouseByID() throws Exception {
        final WebTarget target = target()
                .path("house");
        Response response = target.path("7").request(MediaType.APPLICATION_JSON_TYPE).get();

        final GoHoHouse house = response.readEntity(GoHoHouse.class);
        assertEquals(200, response.getStatus());
        assertEquals(7, house.getID());
    }

    @Test
    public void testSearchByStreet() throws Exception {
        final WebTarget target = target().path("house");
        Response response = target.path("search/street")
                .queryParam("q", "南光路")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        GoHoHouseContainer container = response.readEntity(GoHoHouseContainer.class);
        assertTrue(container.getHouses().size() > 0);
    }

    private List<ValidationError> getValidationErrorList(final Response response) {
        return response.readEntity(new GenericType<List<ValidationError>>() {});
    }

    private Set<String> getValidationMessageTemplates(final Response response) {
        return getValidationMessageTemplates(getValidationErrorList(response));
    }

    private Set<String> getValidationMessageTemplates(final List<ValidationError> errors) {
        final Set<String> templates = new HashSet<String>();
        for (final ValidationError error : errors) {
            templates.add(error.getMessageTemplate());
        }
        return templates;
    }
}
