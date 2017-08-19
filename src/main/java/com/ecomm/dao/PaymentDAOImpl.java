package com.ecomm.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dbentity.Item;
import com.ecomm.dbentity.Order;
import com.ecomm.dbentity.Payment;
import com.ecomm.ws.services.OrderStatus;


public class PaymentDAOImpl implements PaymentDAO {

	public Payment makePayment(Payment payment) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String paymentId = (String) session.save(payment);
		return (Payment) session.get(Payment.class, paymentId);
	}

	public Payment listPaymentByPaymentId(String paymentId) {
		return (Payment)DatabaseSessionManager.getDatabaseSession().get(Payment.class, paymentId);
	}

	public List<Payment> listAllPayments() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Payment").list();
	}

	public List<Payment> listPaymentByPaymentDate(String date) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Payment.class);
		String dateString = new SimpleDateFormat("dd-MM-YYYY").format(date);
		criteria.add(Restrictions.eq("paymentDate", dateString));
		return criteria.list();
	}

	public List<Payment> listAllPaymentsBetweenDates(String fromDate, String toDate) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Payment.class);
		String fromDateString = new SimpleDateFormat("dd-MM-YYYY").format(fromDate);
		String toDateString = new SimpleDateFormat("dd-MM-YYYY").format(toDate);
		criteria.add(Restrictions.le("paymentDate", toDateString));
		return criteria.list();
	}
	
	public List<Payment> listPaymentsyByOrderId(String orderId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Payment.class);
		criteria.add(Restrictions.eq("orderId", orderId));
		return criteria.list();
	}

	public List<Payment> listPaymentsyByUserId(String userId) {
		
		Session session = DatabaseSessionManager.getDatabaseSession();
		
		DetachedCriteria subCriteria = DetachedCriteria.forClass(Order.class);
		subCriteria.add(Restrictions.eq("userId", userId));
		subCriteria.setProjection(Projections.property("orderId"));	

		DetachedCriteria outCriteria = DetachedCriteria.forClass(Payment.class);
		outCriteria.add(Property.forName("orderId").in(subCriteria));
		
		Criteria executableCriteria = outCriteria.getExecutableCriteria(session);
		List list = executableCriteria.list();
		EcommLogger.info("Nest query result in DAO = "+list);
		return list;
	}

	public Payment updatePayment(Payment payment) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(payment);
		return (Payment)session.get(Payment.class, payment.getPaymentId());
	}

	public void deletePayment(Payment payment) {
		DatabaseSessionManager.getDatabaseSession().delete(payment);
	}

	public void deletePaymentByOrderId(String orderId) {
		String deleteHql = "delete from Payment where orderId= :orderId";
		DatabaseSessionManager.getDatabaseSession()
			.createQuery(deleteHql).setString("orderId", orderId).executeUpdate();
	}

	public void deletePaymentByPaymentId(String paymentId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Payment payment = (Payment)session.get(Payment.class, paymentId);
		session.delete(payment);
	}

	public void deleteAllPayments() {
		DatabaseSessionManager.getDatabaseSession().createQuery("delete from Item").executeUpdate();
	}
	
	
}
