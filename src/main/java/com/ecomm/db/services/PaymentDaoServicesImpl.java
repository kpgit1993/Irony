package com.ecomm.db.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ecomm.dao.OrderDAO;
import com.ecomm.dao.PaymentDAO;
import com.ecomm.dbentity.Order;
import com.ecomm.dbentity.Payment;
import com.ecomm.exception.EcommException;
import com.ecomm.ws.services.OrderStatus;
import com.ecomm.ws.utils.ErrorMessage;

import org.springframework.transaction.annotation.Transactional;


public class PaymentDaoServicesImpl {
	
	private PaymentDAO paymentDAO;
	private OrderDAO orderDAO;
	
	public void setPaymentDAO(PaymentDAO paymentDAO) {
		this.paymentDAO = paymentDAO;
	}
	
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
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
}
