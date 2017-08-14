package com.ecomm.interceptors;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;

import com.ecomm.commonutility.logger.EcommLogger;

public class ResponseBodyFormatter implements ContainerResponseFilter {

	public void filter(ContainerRequestContext requestContext,
			ContainerResponseContext responseContext) throws IOException {
		
		String entity = responseContext.getEntity().toString();
		EcommLogger.info("FILTER JSON: "+entity);
		//String modEntity = "[" + entity.split("[")[1].split("]")[0] + "]";
		//responseContext.setEntity(modEntity, null, MediaType.APPLICATION_JSON_TYPE);	
	}

	
}
