package com.ecomm.wsentity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="payments")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payments {

	@XmlElement(name="payment")
    private List<Payment> paymentList; 
    
    public Payments(){
    	this.paymentList = new ArrayList<Payment>();
    }
	
	public List<Payment> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<Payment> paymentList) {
		this.paymentList = paymentList;
	}

	public void addPayment(Payment payment) {
		this.paymentList.add(payment);
	}
}
