package com.ecomm.dao;

import java.util.List;

import com.ecomm.dbentity.Item;

public interface ItemDAO {

	List<Item> listAllItems();
	Item listItemByItemId(String id);
	
}
