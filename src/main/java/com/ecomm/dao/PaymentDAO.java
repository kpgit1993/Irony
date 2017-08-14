package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Payment;


public interface PaymentDAO {

	public Payment makePayment(Payment payment); 
	public Payment listPaymentByPaymentId(String paymentId);
	public List<Payment> listAllPayments();
	public List<Payment> listPaymentByPaymentDate(String Date);
	public List<Payment> listAllPaymentsBetweenDates(String fromDate, String toDate);
	
}
