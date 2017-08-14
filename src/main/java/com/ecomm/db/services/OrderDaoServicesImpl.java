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
	public List<com.ecomm.dbentity.Order> listAllOrders() throws EcommException {
		try{
			return orderDAO.listAllOrders();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public com.ecomm.dbentity.Order listOrderByOrderId(String id) throws EcommException {
		try{
			return orderDAO.listOrderByOrderId(id);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public com.ecomm.dbentity.Order addOrder(com.ecomm.dbentity.Order order) throws EcommException {
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
}
