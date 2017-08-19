package com.ecomm.ws.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	@Path(ServicePaths.LIST_PAYMENT_BY_PAYMENT_ID)
	public Response listPaymentByPaymentId(@PathParam("paymentId") String paymentId);

	@GET
	@Path(ServicePaths.LIST_PAYMENTS_BY_DATE)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByPaymentDate(@QueryParam("paymentDate") String paymentDate);
	
	@GET
	@Path(ServicePaths.LIST_PAYMENT_BY_ORDER_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByOrderId(@QueryParam("orderId") String orderId);
	
	@GET
	@Path(ServicePaths.LIST_PAYMENTS_BY_USER_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByUserId(@QueryParam("userId") String userId);
	
	@GET
	@Path(ServicePaths.LIST_PAYMENTS_BY_USER_EMAIL)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByUserEmailId(@QueryParam("emailId") String emailId);
	
	@GET
	@Path(ServicePaths.LIST_PAYMENTS_BY_USER_MOBILE_NO)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByUserMobileNumber(@QueryParam("mno") String mno);
	
	@GET
	@Path(ServicePaths.LIST_PAYMENTS_BY_CLOSED_ORDERS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByClosedOrders();
	
	@GET
	@Path(ServicePaths.LIST_PAYMENTS_BY_OPEN_ORDERS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByOpenOrders();
	
	@GET
	@Path(ServicePaths.LIST_PAYMENTS_WITHIN_DATE)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPaymentsyByOpenOrders(
			@QueryParam("fromDate") String fromDate, 
			@QueryParam("toDate") String toDate);
	
	@POST
	@Path(ServicePaths.ADD_PAYMENT)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response makePayment(Payment wspayment, @Context UriInfo uriInfo);

	@PUT
	@Path(ServicePaths.UPDATE_PAYMENT)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updatePayment(Payment wspayment, @Context UriInfo uriInfo);

	@DELETE
	@Path(ServicePaths.DELETE_PAYMENT)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deletePayment(Payment wspayment);
	
	@DELETE
	@Path(ServicePaths.DELETE_ALL_PAYMENTS)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteAllPayments();
	
	@DELETE
	@Path(ServicePaths.DELETE_PAYMENT_BY_PAYMENT_ID)
	public Response deletePaymentByPaymentId(@PathParam("id") String paymentId);
	
	@DELETE
	@Path(ServicePaths.DELETE_PAYMENT_BY_ORDER_ID)
	public Response deletePaymentByOrderId(@QueryParam("orderId") String orderId);

}
