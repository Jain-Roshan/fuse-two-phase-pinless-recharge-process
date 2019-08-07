package com.telkom.pinlessrechargeprocess.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeprocess.balanceadjustment.PostBalanceAdjustment;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeprocess.logicalResourceInventory.LogicalResourceInventory;
import com.telkom.pinlessrechargeprocess.utility.BalanceTopUpWrapper;
import com.telkom.pinlessrechargeprocess.utility.Mapper;

public class BalanceTopUpProcessor implements Processor {

	ObjectMapper objectMapper = new ObjectMapper();
	Logger logger = LoggerFactory.getLogger(BalanceTopUpProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {

		logger.info("==========inside BalanceTopUpProcessor ===========");
		BalanceTopUp balanceTopUp = BalanceTopUpWrapper.BALANCE_TOP_UP;
		String productId= balanceTopUp.getType();
		
		if(productId.equalsIgnoreCase("8001891"))
		{
			PostBalanceAdjustment balanceAdjustment = Mapper.mapFromBalanceTopUpToBalanceAdjustment(balanceTopUp);
			exchange.getOut().setHeader("Target", "PrepayBalanceManagement");
			exchange.getOut().setBody(objectMapper.writeValueAsString(balanceAdjustment));
			
		}else if(productId.equalsIgnoreCase("8002712"))
		{
			exchange.getOut().setHeader("Target", "GetSubscriber");
			exchange.getOut().setBody(productId);
			
		}
	}

}
