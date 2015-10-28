package com.yeahliving.goalhome.ims.filter;

import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import org.glassfish.jersey.server.ContainerException;

@Priority(Priorities.ENTITY_CODER)
public class GZipInterceptor implements ReaderInterceptor, WriterInterceptor {

	private static final String GZIP = "gzip";
	private static final String NEED_GZIP_OUTPUT = "TN-A-NeedGzipOutput";

	@Override
	public Object aroundReadFrom(final ReaderInterceptorContext requestContext)
			throws IOException, WebApplicationException {

		final String contentEncoding = requestContext.getHeaders().getFirst(HttpHeaders.CONTENT_ENCODING);

		if ((contentEncoding != null) && contentEncoding.trim().equals(GZIP)) {

			requestContext.getHeaders().remove(HttpHeaders.CONTENT_ENCODING);

			try {
				requestContext.setInputStream(new GZIPInputStream(requestContext.getInputStream()));
			} catch (final IOException ex) {
				throw new ContainerException(ex);
			}
		}

		final String acceptEncoding = requestContext.getHeaders().getFirst(HttpHeaders.ACCEPT_ENCODING);

		if ((acceptEncoding != null) && acceptEncoding.contains(GZIP)) {

			requestContext.setProperty(NEED_GZIP_OUTPUT, Boolean.TRUE);
		}

		return requestContext.proceed();
	}

	@Override
	public void aroundWriteTo(final WriterInterceptorContext responseContext)
			throws IOException, WebApplicationException {

		responseContext.getHeaders().add(HttpHeaders.VARY, HttpHeaders.ACCEPT_ENCODING); // add
																							// vary
																							// header

		final Boolean isGZipEncodingRequired = (Boolean) responseContext.getProperty(NEED_GZIP_OUTPUT);

		if ((isGZipEncodingRequired != null) && isGZipEncodingRequired.equals(Boolean.TRUE)) {

			// wrap entity with gzip
			if (responseContext.getEntity() != null) {
				responseContext.getHeaders().add(HttpHeaders.CONTENT_ENCODING, GZIP);
				responseContext.setOutputStream(new GZIPOutputStream(responseContext.getOutputStream()));
			}
		}

		responseContext.proceed();
	}
}
