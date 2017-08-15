package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.ItemDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.utils.beanmappers.ItemMapper;
import com.ecomm.ws.services.utils.beanmappers.PaymentMapper;
import com.ecomm.ws.utils.EcommResponse;
import com.ecomm.wsentity.Item;


public class ItemServicesImpl implements ItemServices {

	private ItemDaoServicesImpl itemDaoServices;
	
	public void setItemDaoServices(ItemDaoServicesImpl itemDaoServices) {
		this.itemDaoServices = itemDaoServices;
	}
	
	public Response listAllItems() {
		try{ 
			List<com.ecomm.dbentity.Item> dbitemList = itemDaoServices.listAllItems();
			EcommLogger.info("dbitems: "+dbitemList);
			return EcommResponse.getResponseOk(ItemMapper.mapDbToWs(dbitemList));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listItemByItemId(String itemId) {
		try{ 
			com.ecomm.dbentity.Item dbitem = itemDaoServices.listItemsByItemId(itemId);
			EcommLogger.info("dbitem: "+dbitem);
			return EcommResponse.getResponseOk(ItemMapper.mapDbToWs(dbitem));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response addItem(Item wsitem, UriInfo uriInfo) {
		try{ 
			com.ecomm.dbentity.Item dbitem = itemDaoServices.addItem(ItemMapper.mapWsToDb(wsitem));
			EcommLogger.info("dbitem: "+dbitem);
			return EcommResponse.getResponseCreated(ItemMapper.mapDbToWs(dbitem), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response updateItem(Item wsitem, UriInfo uriInfo) {
		if (wsitem.getItemId() == null) {
			throw new EcommWebException(400, "INVALID ITEM ID = null");
		}
		try{
			com.ecomm.dbentity.Item dbitem = itemDaoServices.updateProduct(ItemMapper.mapWsToDb(wsitem));
			return EcommResponse.getResponseUpdated(ItemMapper.mapDbToWs(dbitem), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteItem(Item wsitem) {
		if (wsitem.getItemId() == null) {
			throw new EcommWebException(400, "INVALID ITEM ID = null");
		}
		try{	
			itemDaoServices.deleteItem(ItemMapper.mapWsToDb(wsitem));
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteItemByItemId(String itemId) {
		if (itemId == null) {
			throw new EcommWebException(400, "INVALID ITEM ID = null");
		}
		try{
			itemDaoServices.deleteItemByItemId(itemId);
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response deleteAllItems() {
		try{
			itemDaoServices.deleteAllItems();
			return EcommResponse.getResponseNoContent();
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

}
