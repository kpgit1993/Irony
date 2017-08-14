package com.ecomm.db.services;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.ecomm.dao.ItemDAO;
import com.ecomm.dbentity.Item;
import com.ecomm.exception.EcommException;


public class ItemDaoServicesImpl {

	private ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	@Transactional
	public List<Item> listAllItems() throws EcommException {
		try{
			return itemDAO.listAllItems();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
	
	@Transactional
	public Item listItemsByItemId(String id) throws EcommException {
		try{
			return itemDAO.listItemByItemId(id);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
