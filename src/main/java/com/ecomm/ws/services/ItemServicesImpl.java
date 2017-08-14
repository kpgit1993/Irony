package com.ecomm.ws.services;

import java.util.List;

import javax.ws.rs.core.Response;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.ItemDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.utils.beanmappers.ItemMapper;
import com.ecomm.ws.utils.EcommResponse;


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
		
		return null;
	}

}
