package com.ecomm.ws.utils;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import org.apache.cxf.rs.security.cors.CorsHeaderConstants;


/**
 * ******************************************************************************
 * This utility class will be used to build the response with customized status
 * codes, cookies, headers, response body etc. with the help of the response
 * builder following a particular standard in order to avoid boilerplate codes
 * in the web-service layer.
 * ******************************************************************************
 */
public class EcommResponse {

	// URI builder is not working...
	private static URI getLocationUri(Object wsentity, UriInfo uriInfo)	throws URISyntaxException {
		String uriPath = String.valueOf(uriInfo.getAbsolutePath());
		if(!uriPath.endsWith("/")){
			uriPath += "/";
		}
		if (wsentity instanceof com.ecomm.wsentity.User) {
			return new URI(uriPath+((com.ecomm.wsentity.User) wsentity).getUserId());
		}
		if (wsentity instanceof com.ecomm.wsentity.Order) {
			return new URI(uriPath+((com.ecomm.wsentity.Order) wsentity).getOrderId());
		}
		if (wsentity instanceof com.ecomm.wsentity.Item) {
			return new URI(uriPath+((com.ecomm.wsentity.Item) wsentity).getItemId());
		}
		if (wsentity instanceof com.ecomm.wsentity.Payment) {
			return new URI(uriPath+((com.ecomm.wsentity.Payment) wsentity).getPaymentId());
		}
		throw new URISyntaxException(String.valueOf(uriInfo.getAbsolutePath()),
				"Failed to resolve the instance type of the entity object to build the response");
	}

	public static Response getResponseCreated(Object wsentity, UriInfo uriInfo) throws URISyntaxException {
		return Response.created(getLocationUri(wsentity, uriInfo)).entity(wsentity)
				.header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*").header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*").build();
	}

	public static Response getResponseOk(Object wsentity) throws URISyntaxException {
		return Response.ok().entity(wsentity)
				.header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*").build();
	}
	
	public static Response getResponseNoContent() throws URISyntaxException {
		return Response.noContent()
				.header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*").build();
	}
	
	public static Response getResponseUpdated(Object wsentity, UriInfo uriInfo) throws URISyntaxException {
		return Response.status(Status.ACCEPTED).entity(wsentity)
			.header("Location", getLocationUri(wsentity, uriInfo)).header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*").build();
	}

	public static Response getResponseOk() {
		return Response.ok().header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "*").build();
	}
}
