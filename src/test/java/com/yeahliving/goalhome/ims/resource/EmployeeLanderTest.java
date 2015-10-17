package com.yeahliving.goalhome.ims.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.validation.ValidationError;
import org.junit.Test;

import com.yeahliving.goalhome.ims.bean.GoHoEmployeeLander;

/**
 * Created by xingfeiy on 9/29/15.
 */
public class EmployeeLanderTest extends ResourceTest {
    private static final GoHoEmployeeLander lander_1;
    private static final GoHoEmployeeLander lander_2;

    static {
        lander_1 = new GoHoEmployeeLander();
        lander_1.setUser_name("user_1");
        lander_1.setPassword("password_1");
        lander_2 = new GoHoEmployeeLander();
        lander_2.setUser_name("user_2");
        lander_2.setPassword("password_2");
    }

    @Test
    public void testAddContact() throws Exception {
        final WebTarget target = target()
                .path("emp_login");
        final Response response = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(lander_1, MediaType.APPLICATION_JSON_TYPE));

        final GoHoEmployeeLander lander = response.readEntity(GoHoEmployeeLander.class);

        assertEquals(200, response.getStatus());
        assertNotNull(lander.getId());

        final Response invalidResponse = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(lander_1, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(500, invalidResponse.getStatus());
        assertTrue(getValidationMessageTemplates(invalidResponse).contains("{lander.already.exist}"));

//        assertEquals(200, target.path("" + lander.getId()).request(MediaType.APPLICATION_JSON_TYPE).delete().getGohoStatus());
    }

    @Test
    public void testContactDoesNotExist() throws Exception {
        final WebTarget target = target()
                .path("contact");

        // GET
        Response response = target.path("1").request(MediaType.APPLICATION_JSON_TYPE).get();

        assertEquals(500, response.getStatus());

        Set<String> violationsMessageTemplates = getValidationMessageTemplates(response);
        assertEquals(1, violationsMessageTemplates.size());
        assertTrue(violationsMessageTemplates.contains("{contact.does.not.exist}"));

        // DELETE
        response = target.path("1").request(MediaType.APPLICATION_JSON_TYPE).delete();

        assertEquals(500, response.getStatus());

        violationsMessageTemplates = getValidationMessageTemplates(response);
        assertEquals(1, violationsMessageTemplates.size());
        assertTrue(violationsMessageTemplates.contains("{contact.does.not.exist}"));
    }

    @Test
    public void testContactWrongId() throws Exception {
        final WebTarget target = target()
                .path("contact");

        // GET
        Response response = target.path("-1").request(MediaType.APPLICATION_JSON_TYPE).get();

        assertEquals(400, response.getStatus());

        Set<String> violationsMessageTemplates = getValidationMessageTemplates(response);
        assertEquals(1, violationsMessageTemplates.size());
        assertTrue(violationsMessageTemplates.contains("{contact.wrong.id}"));

        // DELETE
        response = target.path("-2").request(MediaType.APPLICATION_JSON_TYPE).delete();

        assertEquals(400, response.getStatus());

        violationsMessageTemplates = getValidationMessageTemplates(response);
        assertEquals(1, violationsMessageTemplates.size());
        assertTrue(violationsMessageTemplates.contains("{contact.wrong.id}"));
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

    @Test
    public void testAddInvalidContact() throws Exception {
        final GoHoEmployeeLander entity = new GoHoEmployeeLander();
//        entity.setPhone("Crrrn");

        final Response response = target()
                .path("contact")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(entity, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(400, response.getStatus());

        final List<ValidationError> validationErrorList = getValidationErrorList(response);
        for (final ValidationError validationError : validationErrorList) {
            assertTrue(validationError.getPath().contains("ContactCardResource.addContact.contact."));
        }

        final Set<String> messageTemplates = getValidationMessageTemplates(validationErrorList);
        assertEquals(2, messageTemplates.size());
        assertTrue(messageTemplates.contains("{contact.wrong.name}"));
        assertTrue(messageTemplates.contains("{contact.wrong.phone}"));
    }

    @Test
    public void testSearchByUnknown() throws Exception {
        final Response response = target()
                .path("contact")
                .path("search/unknown")
                .queryParam("q", "er")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(400, response.getStatus());

        final Set<String> messageTemplates = getValidationMessageTemplates(response);
        assertEquals(1, messageTemplates.size());
        assertTrue(
                messageTemplates.contains("{org.glassfish.jersey.examples.beanvalidation.webapp.constraint.SearchType.message}"));
    }

    @Test
    public void testSearchByEmailEmpty() throws Exception {
        final Response response = target()
                .path("contact")
                .path("search/email")
                .queryParam("q", "er")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(200, response.getStatus());

        final List<GoHoEmployeeLander> result = response.readEntity(new GenericType<List<GoHoEmployeeLander>>() {});
        assertEquals(0, result.size());
    }

    @Test
    public void testSearchByPhoneInvalid() throws Exception {
        final Response response = target()
                .path("contact")
                .path("search/phone")
                .queryParam("q", (String) null)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        assertEquals(400, response.getStatus());

        final Set<String> messageTemplates = getValidationMessageTemplates(response);
        assertEquals(1, messageTemplates.size());
        assertTrue(messageTemplates.contains("{search.string.empty}"));
    }

    @Test
    public void testSearchByName() throws Exception {
        final WebTarget target = target().path("contact");
        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(lander_1, MediaType.APPLICATION_JSON_TYPE));
        target.request(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(lander_2, MediaType.APPLICATION_JSON_TYPE));

        Response response = target.path("search/name")
                .queryParam("q", "er")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        List<GoHoEmployeeLander> contactCards = response.readEntity(new GenericType<List<GoHoEmployeeLander>>() {});

        assertEquals(200, response.getStatus());
        assertEquals(2, contactCards.size());

        for (final GoHoEmployeeLander contactCard : contactCards) {
//            assertTrue(contactCard.getFullName().contains("er"));
        }

        response = target.path("search/name")
                .queryParam("q", "Foo")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();

        contactCards = response.readEntity(new GenericType<List<GoHoEmployeeLander>>() {});

        assertEquals(200, response.getStatus());
        assertEquals(1, contactCards.size());
//        assertTrue(contactCards.get(0).getFullName().contains("Foo"));

        assertEquals(200, target.request(MediaType.APPLICATION_JSON_TYPE).delete().getStatus());
    }
}
