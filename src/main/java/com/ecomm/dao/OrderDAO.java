package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Order;


public interface OrderDAO {

	public List<Order> listAllOrders();

	public Order listOrderByOrderId(String id);

	public Order addOrder(Order order);

	public void deleteOrderByOrderId(String orderId);

	public void deleteAllOrders();

	public Order updateOrder(Order order);

	public List<Order> listOrdersByUserId(String userId);

	public List<Order> listPlacedOrdersByUserId(String userId);

	public List<Order> listClosedOrdersByUserId(String userId);

	public List<Order> listOrdersBetweenDates(String fromDate, String toDate);

	public List<Order> listClosedOrdersByDate(String date);

	public List<Order> listPlacedOrdersByDate(String date);

	public List<Order> listOrdersByDate(String date);

	public List<Order> listPlacedOrdersBetweenDates(String fromDate, String toDate);

	public List<Order> listClosedOrdersBetweenDates(String fromDate, String toDate);

}
