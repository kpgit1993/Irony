package com.ecomm.db.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.PaymentDAO;
import com.ecomm.dao.UserDAO;
import com.ecomm.dbentity.Order;
import com.ecomm.dbentity.Payment;
import com.ecomm.dbentity.User;
import com.ecomm.exception.EcommException;
import com.ecomm.ws.services.OrderStatus;
import com.ecomm.ws.utils.ErrorMessage;

import org.springframework.transaction.annotation.Transactional;


public class PaymentDaoServicesImpl {
	
	private PaymentDAO paymentDAO;
	private OrderDAO orderDAO;
	private UserDAO userDAO;
	
	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	private static void validatePayment(Payment payment, Order order) throws EcommException {
		// verify order status
		if(order.getOrderStatus().equals(OrderStatus.CLOSED)){
			throw new EcommException(500, ErrorMessage.INVALID_STATUS_FOR_PAYMENT);
		}
		// verify payment amount
		if(order.getCost().intValue() != payment.getPaymentAmount().intValue()){
			throw new EcommException(500, ErrorMessage.INVALID_PAYMENT_AMOUNT);
		}
	}
	
	@Transactional
	public Payment makePayment(Payment payment) throws EcommException {
		try{
			// get the order that corresponds to the payment
			String orderId = payment.getOrderId();
			Order order = orderDAO.listOrderByOrderId(orderId);
			
			// validate payment
			validatePayment(payment, order);
			
			// set payment date
			payment.setPaymentDate(new Date());;
			
			// update order table
			order.setOrderStatus(OrderStatus.CLOSED);
			orderDAO.updateOrder(order);
			
			// update the payment table
			return paymentDAO.makePayment(payment);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Payment listPaymentByPaymentId(String paymentId) throws EcommException {
		try{
			return paymentDAO.listPaymentByPaymentId(paymentId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listAllPayments() throws EcommException {
		try{
			return paymentDAO.listAllPayments();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listPaymentByPaymentDate(String date) throws EcommException {
		try{
			return paymentDAO.listPaymentByPaymentDate(date);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listAllPaymentsBetweenDates(String fromDate, 
			String toDate) throws EcommException {
		try{
			return paymentDAO.listAllPaymentsBetweenDates(fromDate, toDate);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listPaymentsyByOrderId(String orderId) throws EcommException {
		try{
			return paymentDAO.listPaymentsyByOrderId(orderId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listPaymentsyByUserId(String userId) throws EcommException {
		try{
			return paymentDAO.listPaymentsyByUserId(userId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listPaymentsyByUserEmailId(String emailId) throws EcommException {
		try{
			User user = userDAO.listUserByMailId(emailId); 
			EcommLogger.info("user = "+user);
			return paymentDAO.listPaymentsyByUserId(user.getUserId());
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Payment> listPaymentsyByUserMobileNumber(String mno) throws EcommException {
		try{
			User user = userDAO.listUserByMobileNumber(Integer.parseInt(mno)); 
			EcommLogger.info("user = "+user);
			return paymentDAO.listPaymentsyByUserId(user.getUserId());
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public Payment updatePayment(Payment payment) throws EcommException {
		try{
			return paymentDAO.updatePayment(payment);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
