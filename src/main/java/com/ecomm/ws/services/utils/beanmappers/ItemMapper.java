package com.ecomm.ws.services.utils.beanmappers;

import java.util.List;

import com.ecomm.dbentity.Item;
import com.ecomm.wsentity.Items;

public class ItemMapper {

	private static final String MAP_ID = "item_mapping"; 
	
	public static com.ecomm.dbentity.Item mapWsToDb(com.ecomm.wsentity.Item wsitem) {
		com.ecomm.dbentity.Item dbitem = new com.ecomm.dbentity.Item();
		DozerMapper.getBeanMapper().map(wsitem, dbitem, ItemMapper.MAP_ID);
		return dbitem;
	}

	public static com.ecomm.wsentity.Item mapDbToWs(com.ecomm.dbentity.Item dbitem) {
		com.ecomm.wsentity.Item wsitem = new com.ecomm.wsentity.Item();
		DozerMapper.getBeanMapper().map(dbitem, wsitem, ItemMapper.MAP_ID);
		return wsitem;
	}

	public static com.ecomm.wsentity.Items mapDbToWs(List<com.ecomm.dbentity.Item> dbitemList) {
		Items wsitems = new Items();
		if(dbitemList!=null && !dbitemList.isEmpty()){
			for (com.ecomm.dbentity.Item dbitem : dbitemList) {
				com.ecomm.wsentity.Item wsitem = new com.ecomm.wsentity.Item();
				DozerMapper.getBeanMapper().map(dbitem, wsitem, ItemMapper.MAP_ID);
				wsitems.addItem(wsitem);
			}
		}	
		return wsitems;
	}
}
