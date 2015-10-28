package com.yeahliving.goalhome.ims.resource;

import javax.ws.rs.core.Application;

import org.eclipse.persistence.jaxb.BeanValidationMode;
import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import com.yeahliving.goalhome.ims.ServiceApplication;

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
		// Turn off BV otherwise the entities on client would be validated as
		// well.
		config.register(new MoxyJsonConfig()
				.property(MarshallerProperties.BEAN_VALIDATION_MODE, BeanValidationMode.NONE).resolver());
	}

}
