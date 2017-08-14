package com.ecomm.ws.services.utils.beanmappers;

import java.util.List;
import com.ecomm.wsentity.Payments;
import com.ecomm.wsentity.Users;


public class PaymentMapper {

	private static final String MAP_ID = "payment_mapping"; 
	
	public static com.ecomm.dbentity.Payment mapWsToDb(com.ecomm.wsentity.Payment wspayment) {
		com.ecomm.dbentity.Payment dbpayment = new com.ecomm.dbentity.Payment();
		DozerMapper.getBeanMapper().map(wspayment, dbpayment, PaymentMapper.MAP_ID);
		return dbpayment;
	}

	public static com.ecomm.wsentity.Payment mapDbToWs(com.ecomm.dbentity.Payment dbpayment) {
		com.ecomm.wsentity.Payment wspayment = new com.ecomm.wsentity.Payment();
		DozerMapper.getBeanMapper().map(dbpayment, wspayment, PaymentMapper.MAP_ID);
		return wspayment;
	}
	
	public static com.ecomm.wsentity.Payments mapDbToWs(List<com.ecomm.dbentity.Payment> dbpaymentList) {
		Payments wspayments = new Payments();
		if(dbpaymentList!=null && !dbpaymentList.isEmpty()){
			for (com.ecomm.dbentity.Payment dbpayment : dbpaymentList) {
				com.ecomm.wsentity.Payment wspayment = new com.ecomm.wsentity.Payment();
				DozerMapper.getBeanMapper().map(dbpayment, wspayment, PaymentMapper.MAP_ID);
				wspayments.addPayment(wspayment);
			}
		}	
		return wspayments;
	}
}
