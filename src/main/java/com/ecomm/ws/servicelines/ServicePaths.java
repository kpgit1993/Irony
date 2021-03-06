package com.ecomm.ws.servicelines;

public interface ServicePaths {

	// user service path constants
	String USER_SERVICE_BASE_URI 				= 	"/user-services";
	String LIST_ALL_USERS	 					= 	"/users";
	String LIST_USER_BY_ID 						= 	"/users/user/id/{userId}";
	String LIST_USER_BY_EMAIL					= 	"/users/user/email/{email}";
	String LIST_USER_BY_MOBILE_NO				= 	"/users/user/mno/{mobileNo}";
	String ADD_USER								= 	"/users/user";
	/**
	 * Update and delete user operation requires proper authorization
	 */
	String UPDATE_USER							=	"/users/user";
	String DELETE_USER							=	"/users/user";
	String DELETE_ALL_USERS						=	"/users";
	String DELETE_USER_BY_USER_ID				=	"/users/user";
	String DELETE_USER_BY_MOBILE_NO				=	"/users/user";
	String DELETE_USER_BY_EMAIL					=	"/users/user";
	
	
	// order service path constants
	String ORDER_SERVICE_BASE_URI				= 	"/order-services";
	String LIST_ALL_ORDERS 						= 	"/orders";
	String LIST_ORDER_BY_ID 					= 	"/orders/order/id/{orderId}";
	
	String LIST_ORDERS_BY_USER_ID 				= 	"/orders/order";
	String LIST_PLACED_ORDERS_BY_USER_ID 		= 	"/orders/placed-orders";
	String LIST_CLOSED_ORDERS_BY_USER_ID 		= 	"/orders/closed-orders";
	
	String LIST_ORDERS_BY_DATE 					= 	"/orders";
	String LIST_PLACED_ORDERS_BY_DATE			=	"/orders/placed-orders";
	String LIST_CLOSED_ORDERS_BY_DATE			=	"/orders/closed-orders";
			
	String LIST_ORDERS_BETWEEN_DATES 			= 	"/orders";
	String LIST_PLACED_ORDERS_BETWEEN_DATES		=	"/orders/placed-orders";
	String LIST_CLOSED_ORDERS_BETWEEN_DATES		=	"/orders/closed-orders";
	
	String ADD_ORDER 							= 	"/orders/order";
	String UPDATE_ORDER 						= 	"/orders/order";
	String DELETE_ALL_ORDERS 					= 	"/orders";
	String DELETE_ORDER_BY_ID 					= 	"/orders/order/id/{orderId}";
	
	
	// item service path constants
	String ITEM_SERVICE_BASE_URI				= 	"/item-services";
	String LIST_ALL_ITEMS						= 	"/items";
	String LIST_ITEM_BY_ID 						= 	"/items/item/id/{itemId}";
	String LIST_ITEM_BY_ITEM_CATEGORY 			= 	"/items";
	String UPDATE_ITEM 							= 	"/items/item";
	String ADD_ITEM 							= 	"/items/item";
	String DELETE_ITEM 							=	"/items/item";
	String DELETE_ITEM_BY_ID 					= 	"/items/item/id/{itemId}";
	String DELETE_ALL_ITEMS						= 	"/items";
	
	
	// payment service path constants
	String PAYMENT_SERVICE_BASE_URI				= 	"/payment-services";
	String LIST_ALL_PAYMENTS 					= 	"/payments";
	String LIST_PAYMENT_BY_PAYMENT_ID 			= 	"/payments/payment";
	String LIST_PAYMENT_BY_ORDER_ID				=  	"/payments/payment";
	String LIST_PAYMENTS_BY_USER_ID				=	"/payments/payment";
	String LIST_PAYMENTS_BY_USER_EMAIL			=	"/payments";
	String LIST_PAYMENTS_BY_USER_MOBILE_NO		=	"/payments";
	
	String LIST_PAYMENTS_BY_DATE 				= 	"/payments/date";
	String LIST_PAYMENTS_WITHIN_DATE 			= 	"/payments";
	
	String ADD_PAYMENT 							=	"/payments/payment";
	String UPDATE_PAYMENT 						=	"/payments/payment";
	
	String DELETE_PAYMENT 						=	"/payments/payment";
	String DELETE_ALL_PAYMENTS 					=	"/payments";
	String DELETE_PAYMENT_BY_PAYMENT_ID			=	"/payments/payment";
	String DELETE_PAYMENT_BY_ORDER_ID			=	"/payments/payment";
	
}