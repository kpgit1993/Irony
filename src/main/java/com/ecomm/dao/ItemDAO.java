package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Item;


public interface ItemDAO {

	List<Item> listAllItems();
	
	Item listItemByItemId(String id);
	
	Item addItem(Item item);
	
	Item updateItem(Item item);
	
	void deleteItem(Item item);
	
	void deleteItemByItemId(String itemId);
	
	void deleteAllItems();
	
}
