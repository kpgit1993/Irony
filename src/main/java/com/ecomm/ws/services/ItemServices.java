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
import com.ecomm.wsentity.Item;


@Path(ServicePaths.ITEM_SERVICE_BASE_URI)
public interface ItemServices {

	@GET
	@Path(ServicePaths.LIST_ALL_ITEMS)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listAllItems();

	@GET
	@Path(ServicePaths.LIST_ITEM_BY_ID)
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Response listItemByItemId(@PathParam("itemId") String itemId);

	@GET
	@Path(ServicePaths.LIST_ITEM_BY_ITEM_CATEGORY)
	public Response listItemByItemCategory(@QueryParam("category") String category);
	
	@POST
	@Path(ServicePaths.ADD_ITEM)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response addItem(Item wsitem, @Context UriInfo uriInfo);
	
	@PUT
	@Path(ServicePaths.UPDATE_ITEM)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response updateItem(Item wsitem, @Context UriInfo uriInfo);

	@DELETE
	@Path(ServicePaths.DELETE_ITEM)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response deleteItem(Item wsitem);
	
	@DELETE
	@Path(ServicePaths.DELETE_ITEM_BY_ID)
	public Response deleteItemByItemId(@PathParam("id") String itemId);
	
	@DELETE
	@Path(ServicePaths.DELETE_ALL_ITEMS)
	public Response deleteAllItems();
}
