package com.ecomm.ws.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.ecomm.ws.servicelines.ServicePaths;
import com.ecomm.wsentity.Payment;


@Path(ServicePaths.PAYMENT_SERVICE_BASE_URI)
public interface PaymentServices {

	@GET
	@Path(ServicePaths.LIST_ALL_PAYMENTS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listAllPayments();

	@GET
	@Path(ServicePaths.LIST_PAYMENT_BY_DATE)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentByPaymentId(@PathParam("paymentId") String paymentId);
	
	@POST
	@Path(ServicePaths.LIST_PAYMENT_WITHIN_DATE)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response makePayment(Payment wspayment, @Context UriInfo uriInfo);

}
