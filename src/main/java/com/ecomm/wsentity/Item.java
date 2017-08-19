package com.ecomm.wsentity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="item")
public class Item {

	private String itemId;
	private String itemName;
	private String itemSize;
	private String itemCategory;
	private String itemDetails;
	private Integer cost;
	
	public Item(){
		//For Hibernate Serialization
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		return 
			"{"+this+": "
				+ "itemId="+this.itemId
				+ "itemName="+this.itemName
				+ "itemCategory="+this.itemCategory
				+ "itemSize="+this.itemSize
				+ "itemDetails="+this.itemDetails
				+ "cost="+this.cost
			+"}";
	}
}
