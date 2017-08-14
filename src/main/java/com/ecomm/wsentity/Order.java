package com.ecomm.wsentity;

import java.util.Date;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="order")
public class Order {

	private String orderId;
	private Date orderDate;
	private String address;
	private String orderStatus;
	private String userId;
	private Integer cost;
	private Map<String, Integer> orderDetails;  

	public Order(){
		// for Hibernate serialization
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public Map<String, Integer> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Map<String, Integer> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
