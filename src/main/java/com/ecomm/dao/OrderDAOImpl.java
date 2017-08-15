package com.ecomm.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.ecomm.dbentity.Order;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.ws.services.OrderStatus;


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

	public Order updateOrder(Order order) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(order);
		return (Order) session.get(Order.class, order.getOrderId());
	}

	/**
	 * https://stackoverflow.com/questions/4444045/criteria-v-s-hql-who-is-faster
	 * Criteria is recommended for all the versions in Hibernate over HQL queries
	 */
	public List listOrdersByUserId(String userId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}

	public List listPlacedOrdersByUserId(String userId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderStatus", OrderStatus.PLACED));
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}

	public List listClosedOrdersByUserId(String userId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderStatus", OrderStatus.CLOSED));
		criteria.add(Restrictions.eq("userId", userId));
		return criteria.list();
	}

	public List listOrdersBetweenDates(String fromDate, String toDate) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.ge("orderDate", fromDate));
		criteria.add(Restrictions.le("toDate", toDate));
		return criteria.list();
	}

	public List listClosedOrdersByDate(String date) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderDate", date));
		criteria.add(Restrictions.eq("orderStatus", OrderStatus.CLOSED));
		return criteria.list();
	}

	public List listPlacedOrdersByDate(String date) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderDate", date));
		criteria.add(Restrictions.eq("orderStatus", OrderStatus.PLACED));
		return criteria.list();
	}

	public List listOrdersByDate(String date) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderDate", date));
		return criteria.list();
	}

	public List listPlacedOrdersBetweenDates(String fromDate, String toDate) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.ge("orderDate", fromDate));
		criteria.add(Restrictions.le("toDate", toDate));
		criteria.add(Restrictions.eq("orderStatus", OrderStatus.PLACED));
		return criteria.list();
	}

	public List listClosedOrdersBetweenDates(String fromDate, String toDate) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Order.class);
		criteria.add(Restrictions.ge("orderDate", fromDate));
		criteria.add(Restrictions.le("toDate", toDate));
		criteria.add(Restrictions.eq("orderStatus", OrderStatus.CLOSED));
		return criteria.list();
	}

}
