package com.ecomm.dao;

import java.util.List;

import com.ecomm.dbentity.Order;

public interface OrderDAO {

	public List<Order> listAllOrders();

	public Order listOrderByOrderId(String id);

	public Order addOrder(Order order);

	public void deleteOrderByOrderId(String orderId);

	public void deleteAllOrders();

	public void updateOrder(Order order);
}
