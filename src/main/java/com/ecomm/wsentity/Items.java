package com.ecomm.wsentity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="items")
@XmlAccessorType(XmlAccessType.FIELD)
public class Items {

	@XmlElement(name="item")
    private List<Item> itemList; 

    public Items(){
    	this.itemList = new ArrayList<Item>();
    }

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public void addItem(Item item) {
		this.itemList.add(item);
	}
}
