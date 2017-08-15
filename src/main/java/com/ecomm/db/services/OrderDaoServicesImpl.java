package com.ecomm.db.services;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.ItemDAO;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dbentity.Item;
import com.ecomm.dbentity.Order;
import com.ecomm.dbentity.OrderDetails;
import com.ecomm.exception.EcommException;
import com.ecomm.ws.services.OrderStatus;


public class OrderDaoServicesImpl {
	
	private OrderDAO orderDAO;
	
	private ItemDAO itemDAO;
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	
	@Transactional
	public List<Order> listAllOrders() throws EcommException {
		try{
			return orderDAO.listAllOrders();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Order listOrderByOrderId(String id) throws EcommException {
		try{
			return orderDAO.listOrderByOrderId(id);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Order addOrder(Order order) throws EcommException {
		try{
			// Add required properties for the order
			order.setOrderDate(new Date());
			order.setOrderStatus(OrderStatus.PLACED);
			
			// Calculate order cost
			int cost = 0;
			Map itemList = order.getOrderDetails();
			EcommLogger.debug("ALL items = "+itemList);			
			Set<String> itemIdSet = itemList.keySet();
			for(String itemId : itemIdSet){
				EcommLogger.debug("Check cost per unit for item id = "+itemId);
				Item item = itemDAO.listItemByItemId(itemId);
				cost += item.getCost() * ((OrderDetails)itemList.get(itemId)).getOrderItemNo();
			}
			order.setCost(cost);
			return orderDAO.addOrder(order);			
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteOrderByOrderId(String orderId) throws EcommException {
		try{
			orderDAO.deleteOrderByOrderId(orderId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteAllOrders() throws EcommException {
		try{
			orderDAO.deleteAllOrders();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Order updateOrder(Order order) throws EcommException {
		try{
			return orderDAO.updateOrder(order);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listOrdersByUserId(String userId) throws EcommException {
		try{
			return orderDAO.listOrdersByUserId(userId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listPlacedOrdersByUserId(String userId) throws EcommException {
		try{
			return orderDAO.listPlacedOrdersByUserId(userId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listClosedOrdersByUserId(String userId) throws EcommException {
		try{
			return orderDAO.listClosedOrdersByUserId(userId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listOrdersBetweenDates(String fromDate, String toDate) throws EcommException {
		try{
			return orderDAO.listOrdersBetweenDates(fromDate, toDate);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listClosedOrdersByDate(String date) throws EcommException {
		try{
			return orderDAO.listClosedOrdersByDate(date);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listPlacedOrdersByDate(String date) throws EcommException {
		try{
			return orderDAO.listPlacedOrdersByDate(date);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listOrdersByDate(String date) throws EcommException {
		try{
			return orderDAO.listOrdersByDate(date);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listPlacedOrdersBetweenDates(String fromDate, String toDate) throws EcommException {
		try{
			return orderDAO.listPlacedOrdersBetweenDates(fromDate, toDate);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Order> listClosedOrdersBetweenDates(String fromDate, String toDate) throws EcommException {
		try{
			return orderDAO.listClosedOrdersBetweenDates(fromDate, toDate);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
















