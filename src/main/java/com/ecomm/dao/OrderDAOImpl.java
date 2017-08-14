package com.ecomm.dao;

import java.util.List;

import org.hibernate.Session;

import com.ecomm.dbentity.Order;
import com.ecomm.dbentity.User;
import com.ecomm.dao.utils.DatabaseSessionManager;

public class OrderDAOImpl implements OrderDAO {

	public List listAllOrders() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Order").list();
	}

	public Order listOrderByOrderId(String id) {
		return (Order)DatabaseSessionManager.getDatabaseSession().load(Order.class, id);
	}

	public Order addOrder(Order order) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String id = (String) session.save(order);
		return (Order) session.get(Order.class, id);
	}

	public void deleteOrderByOrderId(String orderId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Order order = (Order)session.load(Order.class, orderId);
		session.delete(order);
		session.flush();
	}

	public void deleteAllOrders() {
		DatabaseSessionManager.getDatabaseSession().createQuery("delete from Order").executeUpdate();
	}

	public void updateOrder(Order order) {
		DatabaseSessionManager.getDatabaseSession().update(order);
	}

}
