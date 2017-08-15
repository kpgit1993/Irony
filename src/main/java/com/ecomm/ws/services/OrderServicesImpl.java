package com.ecomm.ws.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.OrderDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.utils.beanmappers.ItemMapper;
import com.ecomm.ws.services.utils.beanmappers.OrderMapper;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.ws.utils.ErrorMessage;
import com.ecomm.wsentity.Order;


public class OrderServicesImpl implements OrderServices {

	private OrderDaoServicesImpl orderDaoServices;
	
	public void setOrderDaoServices(OrderDaoServicesImpl orderDaoServices) {
		this.orderDaoServices = orderDaoServices;
	}
	
	public Response listAllOrders() {
		try{ 
			List<com.ecomm.dbentity.Order> dborderList = orderDaoServices.listAllOrders();
			EcommLogger.info("dborders: "+dborderList);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborderList));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response listOrderByOrderId(String id) {
		if(id == null){
			throw new EcommWebException(400, "Order id = null is not accepted");
		}
		try{ 
			com.ecomm.dbentity.Order dborder = orderDaoServices.listOrderByOrderId(id);
			if (dborder == null) {
				throw new EcommException(500, "Order with id: "+id+" was not found");
			}
			EcommLogger.info("dborder: "+dborder);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborder));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
	public Response addOrder(Order wsorder, UriInfo uriInfo) {
		validateOrder(wsorder);
		try{
			com.ecomm.dbentity.Order dborder = orderDaoServices.addOrder(OrderMapper.mapWsToDb(wsorder));
			com.ecomm.wsentity.Order wsCreatedOrder = OrderMapper.mapDbToWs(dborder);
			return EcommResponse.getResponseCreated(wsCreatedOrder, uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	private static void validateOrder(Order wsorder) {
		
		// verify system generated values for the transaction must be null
		if(wsorder.getOrderId() != null){
			throw new EcommWebException(400, ErrorMessage.INVALID_ORDER_ID);
		}
		if(wsorder.getOrderDate() != null){
			throw new EcommWebException(400, ErrorMessage.INVALID_ORDER_DATE);
		}
		if(wsorder.getOrderStatus() != null){
			throw new EcommWebException(400, ErrorMessage.INVALID_ORDER_STATUS);
		}
		if(wsorder.getCost() != null){
			throw new EcommWebException(400, ErrorMessage.INVALID_ORDER_COST);
		}
		
		// verify order details are provided by the user correctly by the user
		if(wsorder.getUserId() == null){
			throw new EcommWebException(400, ErrorMessage.INVALID_USER_ID);
		}
		if(wsorder.getAddress() == null){
			throw new EcommWebException(400, ErrorMessage.INVALID_ADDRESS);
		}
		if(wsorder.getOrderDetails()==null || wsorder.getOrderDetails().keySet()==null 
				|| wsorder.getOrderDetails().keySet().size()==0){
			throw new EcommWebException(400, ErrorMessage.INVALID_ORDER_DETAILS);
		}
	}

	public Response updateOrder(Order wsorder, UriInfo uriInfo) {
		if (wsorder.getOrderId() == null) {
			throw new EcommWebException(400, "INVALID ORDER ID = null");
		}
		try{
			com.ecomm.dbentity.Order dborder = orderDaoServices.updateOrder(OrderMapper.mapWsToDb(wsorder));
			return EcommResponse.getResponseUpdated(OrderMapper.mapDbToWs(dborder), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteAllOrders() {
		try{	
			orderDaoServices.deleteAllOrders();
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteOrderByOrderId(String orderId) {
		if (orderId == null || orderId.isEmpty()) {
			throw new EcommWebException(400, "INVALID ORDER ID = null");
		}
		try{
			orderDaoServices.deleteOrderByOrderId(orderId);
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listOrdersByUserId(String userId) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listOrdersByUserId(userId);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listPlacedOrdersByUserId(String userId) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listPlacedOrdersByUserId(userId);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listClosedOrdersByUserId(String userId) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listClosedOrdersByUserId(userId);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listOrdersByDate(String date) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listOrdersByDate(date);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listPlacedOrdersByDate(String date) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listPlacedOrdersByDate(date);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listClosedOrdersByDate(String date) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listClosedOrdersByDate(date);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listOrdersBetweenDates(String fromDate, String toDate) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listOrdersBetweenDates(fromDate, toDate);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listPlacedOrdersBetweenDates(String fromDate, String toDate) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listPlacedOrdersBetweenDates(fromDate, toDate);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listClosedOrdersBetweenDates(String fromDate, String toDate) {
		try{ 
			List<com.ecomm.dbentity.Order> dborders = orderDaoServices.listClosedOrdersBetweenDates(fromDate, toDate);
			EcommLogger.info("dborders: "+dborders);
			return EcommResponse.getResponseOk(OrderMapper.mapDbToWs(dborders));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}
	
}