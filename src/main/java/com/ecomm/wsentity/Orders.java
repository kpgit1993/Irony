package com.ecomm.wsentity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders {

	@XmlElement(name="order")
    private List<Order> orderList; 

    public Orders(){
    	this.orderList = new ArrayList<Order>();
    }
    
    public Orders(List<Order> orderList){
    	this.orderList = orderList;
    }

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}
	
	public void addOrder(Order order) {
		this.orderList.add(order);
	}
}
