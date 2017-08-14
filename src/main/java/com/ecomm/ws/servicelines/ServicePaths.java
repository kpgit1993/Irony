package com.ecomm.ws.servicelines;

public interface ServicePaths {

	// user service path constants
	String USER_SERVICE_BASE_URI 	= 	"/user-services";
	String LIST_ALL_USERS	 		= 	"/users";
	String LIST_USER_BY_ID 			= 	"/users/user/{userId}";
	String LIST_USER_BY_EMAIL		= 	"/users/user/{email}";
	String LIST_USER_BY_MOBILE_NO	= 	"/users/user/{mobileNo}";
	String ADD_USER					= 	"/users/user";
	String UPDATE_USER				=	"/users/user";
	
	// order service path constants
	String ORDER_SERVICE_BASE_URI	= 	"/order-services";
	String LIST_ALL_ORDER 			= 	"/orders";
	String LIST_ORDER_BY_ID 		= 	"/orders/order/{orderId}";
	String ADD_ORDER 				= 	"/orders/order";
	String UPDATE_ORDER 			= 	"/orders/order";
	String DELETE_ALL_ORDERS 		= 	"/orders";
	String DELETE_ORDER_BY_ID 		= 	"/orders/order/{orderId}";
	
	// item service path constants
	String ITEM_SERVICE_BASE_URI	= 	"/item-services";
	String LIST_ALL_ITEMS			= 	"/items";
	String LIST_ITEM_BY_ID 			= 	"/items/item/{itemId}";
	
	// item service path constants
	String PAYMENT_SERVICE_BASE_URI	= 	"/payment-services";
	String LIST_ALL_PAYMENTS 		= 	"/payments";
	String LIST_PAYMENT_BY_DATE 	= 	"/payments/date";
	String LIST_PAYMENT_WITHIN_DATE = 	"/payments/";
	
}
