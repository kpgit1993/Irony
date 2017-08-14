package com.ecomm.dbentity;

import java.util.Date;
import java.util.Map;

public class Order {

	private String orderId;
	private Date orderDate;
	private String address;
	private String userId;
	private String orderStatus;
	private Integer cost;
	private Map orderDetails;
	
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

	public Map getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Map orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public String toString(){
		return "{ "+orderId+", "+orderDate+", "+address+", "
				+userId+", "+orderStatus+", "+cost+", "
				+", "+orderDetails+" }";
	}
}
