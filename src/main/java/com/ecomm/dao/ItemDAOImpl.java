package com.ecomm.dao;

import java.util.List;
import com.ecomm.dbentity.Item;
import com.ecomm.dao.utils.DatabaseSessionManager;


public class ItemDAOImpl implements ItemDAO {

	public List listAllItems() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Item").list();
	}

	public Item listItemByItemId(String id) {
		return (Item) DatabaseSessionManager.getDatabaseSession().get(Item.class, id);
	}

	
}
