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

	@Transactional
	public com.ecomm.dbentity.Item addItem(com.ecomm.dbentity.Item item) throws EcommException {
		try{
			return itemDAO.addItem(item);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public com.ecomm.dbentity.Item updateProduct(com.ecomm.dbentity.Item item) throws EcommException {
		try{
			return itemDAO.updateItem(item);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteItem(com.ecomm.dbentity.Item item) throws EcommException {
		try{
			itemDAO.deleteItem(item);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteItemByItemId(String itemId) throws EcommException {
		try{
			itemDAO.deleteItemByItemId(itemId);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public void deleteAllItems() throws EcommException {
		try{
			itemDAO.deleteAllItems();
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}

	@Transactional
	public List<Item> listItemByItemCategory(String category) throws EcommException {
		try{
			return itemDAO.listItemByItemCategory(category);
		}catch(Exception e){
			throw new EcommException(500, e);
		}
	}
}
