package com.ecomm.ws.services;

import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import com.ecomm.wsentity.Payment;
import com.ecomm.commonutility.logger.EcommLogger;
import com.ecomm.db.services.PaymentDaoServicesImpl;
import com.ecomm.exception.EcommException;
import com.ecomm.exception.EcommWebException;
import com.ecomm.ws.services.PaymentServices;
import com.ecomm.ws.services.utils.beanmappers.PaymentMapper;
import com.ecomm.ws.utils.EcommResponse;


public class PaymentServicesImpl implements PaymentServices {

	private PaymentDaoServicesImpl paymentDaoServices;
	
	public void setPaymentDaoServices(PaymentDaoServicesImpl paymentDaoServices) {
		this.paymentDaoServices = paymentDaoServices;
	}

	public Response listAllPayments() {
		try{ 
			List<com.ecomm.dbentity.Payment> dbpaymentList = paymentDaoServices.listAllPayments();
			EcommLogger.info("dbpaymentList : "+dbpaymentList);
			return EcommResponse.getResponseOk(PaymentMapper.mapDbToWs(dbpaymentList));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response listPaymentByPaymentId(String paymentId) {
		try{ 
			com.ecomm.dbentity.Payment dbpayment = paymentDaoServices.listPaymentByPaymentId(paymentId);
			EcommLogger.info("dbpayment: "+dbpayment);
			return EcommResponse.getResponseOk(PaymentMapper.mapDbToWs(dbpayment));
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	public Response makePayment(Payment wspayment, UriInfo uriInfo) {
		try{ 
			com.ecomm.dbentity.Payment dbpayment = paymentDaoServices.makePayment(PaymentMapper.mapWsToDb(wspayment));
			EcommLogger.info("dbpayment: "+dbpayment);
			return EcommResponse.getResponseCreated(PaymentMapper.mapDbToWs(dbpayment), uriInfo);
		}catch (EcommException e) {
			e.printStackTrace();
			throw new EcommWebException(e);
		}catch(Exception e){
			e.printStackTrace();
			throw new EcommWebException(500, e);
		}
	}

	
}
