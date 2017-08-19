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
import com.ecomm.wsentity.Order;


@Path(ServicePaths.ORDER_SERVICE_BASE_URI)
public interface OrderServices {

	@GET
	@Path(ServicePaths.LIST_ALL_ORDERS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listAllOrders();

	@GET
	@Path(ServicePaths.LIST_ORDER_BY_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listOrderByOrderId(@PathParam("orderId") String orderId);
	
	/**
	 * Required for getting the cart information
	 */
	@GET
	@Path(ServicePaths.LIST_ORDERS_BY_USER_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listOrdersByUserId(@QueryParam("userId") String userId);
	
	@GET
	@Path(ServicePaths.LIST_PLACED_ORDERS_BY_USER_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPlacedOrdersByUserId(@QueryParam("userId") String userId);
	
	@GET
	@Path(ServicePaths.LIST_CLOSED_ORDERS_BY_USER_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listClosedOrdersByUserId(@QueryParam("userId") String userId);

	@GET
	@Path(ServicePaths.LIST_ORDERS_BY_DATE)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listOrdersByDate(@QueryParam("date") String date);

	@GET
	@Path(ServicePaths.LIST_PLACED_ORDERS_BY_DATE)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPlacedOrdersByDate(@QueryParam("date") String date);

	@GET
	@Path(ServicePaths.LIST_CLOSED_ORDERS_BY_DATE)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listClosedOrdersByDate(@QueryParam("date") String date);
	
	@GET
	@Path(ServicePaths.LIST_ORDERS_BETWEEN_DATES)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listOrdersBetweenDates(
			@QueryParam("fromDate") String fromDate, 
			@QueryParam("toDate") String toDate);

	@GET
	@Path(ServicePaths.LIST_PLACED_ORDERS_BETWEEN_DATES)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listPlacedOrdersBetweenDates(
			@QueryParam("fromDate") String fromDate, 
			@QueryParam("toDate") String toDate);
	
	@GET
	@Path(ServicePaths.LIST_CLOSED_ORDERS_BETWEEN_DATES)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listClosedOrdersBetweenDates(
			@QueryParam("fromDate") String fromDate, 
			@QueryParam("toDate") String toDate);
	
	@POST
	@Path(ServicePaths.ADD_ORDER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addOrder(Order wsorder, @Context UriInfo uriInfo);
	
	@PUT
	@Path(ServicePaths.UPDATE_ORDER)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateOrder(Order wsorder, @Context UriInfo uriInfo);

	@DELETE
	@Path(ServicePaths.DELETE_ALL_ORDERS)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteAllOrders();
	
	@DELETE
	@Path(ServicePaths.DELETE_ORDER_BY_ID)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteOrderByOrderId(String orderId);
	
}
