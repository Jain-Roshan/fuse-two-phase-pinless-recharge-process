package com.telkom.pinlessrechargeprocess.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeprocess.logicalResourceInventory.LogicalResourceInventory;
import com.telkom.pinlessrechargeprocess.utility.BalanceTopUpWrapper;
import com.telkom.pinlessrechargeprocess.utility.Mapper;

public class GetSubscriberProcessor implements Processor{

	Logger logger = LoggerFactory.getLogger(GetSubscriberProcessor.class);
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("===================inside GetSubscriberProcessor=========");
		
		BalanceTopUp balanceTopUp = BalanceTopUpWrapper.BALANCE_TOP_UP;
		String responseCode = (String) exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE);
		logger.info("====response code is ==="+ responseCode);
		responseCode = "200";
		if("200".equalsIgnoreCase(responseCode))
		{
			LogicalResourceInventory logicalResourceInventory = Mapper.mapFromBalanceTopUpToLogicalResourceInventory(balanceTopUp);
			exchange.getOut().setHeader("Result", "Success");
			exchange.getOut().setBody(objectMapper.writeValueAsString(logicalResourceInventory));
		}
		
	}

	
}
