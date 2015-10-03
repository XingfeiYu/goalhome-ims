package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.ServiceApplication;
import org.eclipse.persistence.jaxb.BeanValidationMode;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.external.ExternalTestContainerFactory;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created by xingfeiy on 10/2/15.
 */
public class ResourceTest extends JerseyTest {
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
}
