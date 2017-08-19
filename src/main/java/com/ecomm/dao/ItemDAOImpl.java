package com.ecomm.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.ecomm.dbentity.Item;
import com.ecomm.dbentity.Order;
import com.ecomm.dao.utils.DatabaseSessionManager;
import com.ecomm.ws.services.OrderStatus;


public class ItemDAOImpl implements ItemDAO {

	public List listAllItems() {
		return DatabaseSessionManager.getDatabaseSession().createQuery("from Item").list();
	}

	public Item listItemByItemId(String id) {
		return (Item) DatabaseSessionManager.getDatabaseSession().get(Item.class, id);
	}

	public Item addItem(Item item) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		String id = (String)session.save(item);
		return (Item)session.get(Item.class, id);
	}

	public Item updateItem(Item item) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		session.update(item);
		return (Item)session.get(Item.class, item.getItemId());
	}

	public void deleteItem(Item item) {
		DatabaseSessionManager.getDatabaseSession().delete(item);
	}

	public void deleteItemByItemId(String itemId) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Item item = (Item)session.get(Item.class, itemId);
		session.delete(item);
	}

	public void deleteAllItems() {
		DatabaseSessionManager.getDatabaseSession().createQuery("delete from Item").executeUpdate();
	}

	public List listItemByItemCategory(String category) {
		Session session = DatabaseSessionManager.getDatabaseSession();
		Criteria criteria = session.createCriteria(Item.class);
		criteria.add(Restrictions.eq("category", category));
		return criteria.list();
	}	
}
