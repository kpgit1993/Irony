package com.ecomm.ws.services.utils.beanmappers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.dbentity.OrderDetails;
import com.ecomm.wsentity.Orders;
import com.ecomm.wsentity.Users;

public class OrderMapper {

	private static final String MAP_ID = "order_mapping"; 
	
	public static com.ecomm.dbentity.Order mapWsToDb(com.ecomm.wsentity.Order wsorder) {
		com.ecomm.dbentity.Order dborder = new com.ecomm.dbentity.Order();
		DozerMapper.getBeanMapper().map(wsorder, dborder, OrderMapper.MAP_ID);
		dborder.setOrderDetails(OrderMapper.getWsOrderDetailsToDb(wsorder));
		return dborder;
	}

	public static com.ecomm.wsentity.Order mapDbToWs(com.ecomm.dbentity.Order dborder) {
		com.ecomm.wsentity.Order wsorder = new com.ecomm.wsentity.Order();
		DozerMapper.getBeanMapper().map(dborder, wsorder, OrderMapper.MAP_ID);
		wsorder.setOrderDetails(OrderMapper.getDbOrderDetailsToWs(dborder));
		return wsorder;
	}
	
	
	// get Map<p, OrderDetails@Object> for dbproducts
	private static Map getWsOrderDetailsToDb(com.ecomm.wsentity.Order wsorder) {
		Map<String, OrderDetails> dbOrderDetails = new HashMap<String, OrderDetails>();
		EcommLogger.info("WEB SERVICE ORDER DETAILS = "+wsorder.getOrderDetails());
		Map ps = wsorder.getOrderDetails();
		Set<String> properties = ps.keySet();
		for(String property : properties){
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setOrderItemNo((Integer)ps.get(property));
			EcommLogger.info("Setting order item no = "+(Integer)ps.get(property));
			dbOrderDetails.put(property, orderDetails);
		}
		EcommLogger.info("DB ENCODED OREDER_DETAILS = "+dbOrderDetails);
		return dbOrderDetails;
	}
	
	// get Map<p, v> for wsproduct
	public static Map<String, Integer> getDbOrderDetailsToWs(com.ecomm.dbentity.Order dborder){
		Map<String, Integer> wsOrderDetails = new HashMap<String, Integer>();
		Map dbOrderDetails = dborder.getOrderDetails();
		Set<String> properties = dbOrderDetails.keySet();
		for(String property : properties){
			wsOrderDetails.put(property, ((OrderDetails)dbOrderDetails.get(property)).getOrderItemNo());
		}
		return wsOrderDetails;
	}

	public static Object mapDbToWs(List<com.ecomm.dbentity.Order> dborderList) {
		Orders wsusers = new Orders();
		if(dborderList!=null && !dborderList.isEmpty()){
			for (com.ecomm.dbentity.Order dborder : dborderList) {
				com.ecomm.wsentity.Order wsorder = new com.ecomm.wsentity.Order();
				DozerMapper.getBeanMapper().map(dborder, wsorder, OrderMapper.MAP_ID);
				wsorder.setOrderDetails(getDbOrderDetailsToWs(dborder));
				wsusers.addOrder(wsorder);
			}
		}
		return wsusers;
	}

}
