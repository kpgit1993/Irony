package com.ecomm.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.dbentity.Order;
import com.ecomm.dbentity.Payment;

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
}
