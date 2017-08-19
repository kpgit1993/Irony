package com.ecomm.dbentity;

public class OrderDetails {

	private String orderDetailsId;
	
	private Integer orderItemNo;
	
	public OrderDetails(){
		// Constructor for hibernate serialization
	}

	public OrderDetails(Integer orderItemNo){
		this.orderItemNo = orderItemNo;
	}

	public String getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(String orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Integer getOrderItemNo() {
		return orderItemNo;
	}

	public void setOrderItemNo(Integer orderItemNo) {
		this.orderItemNo = orderItemNo;
	}
	
	public String toString(){
		return 
				"{"+this+": "
					+ "orderDetailsId="+this.orderDetailsId
					+ "orderItemNo="+this.orderItemNo
				+"}";
	}
}
