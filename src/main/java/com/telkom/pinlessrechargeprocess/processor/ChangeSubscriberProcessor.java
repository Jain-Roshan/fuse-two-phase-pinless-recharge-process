package com.telkom.pinlessrechargeprocess.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUpResponse;
import com.telkom.pinlessrechargeprocess.utility.BalanceTopUpWrapper;

public class ChangeSubscriberProcessor implements Processor{

	Logger logger = LoggerFactory.getLogger(ChangeSubscriberProcessor.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info("========inside ChangeSubscriberProcessor==========");
		BalanceTopUpResponse balanceTopUpResponse = new BalanceTopUpResponse();
		String responseCode = (String) exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE);
		logger.info("====response code is ==="+ responseCode);
		responseCode = "200";
		if("200".equalsIgnoreCase(responseCode))
		{
			balanceTopUpResponse.setCode("200");
			balanceTopUpResponse.setDescription("OK");
			exchange.getOut().setBody("200");
		}else
		{
			balanceTopUpResponse.setCode(responseCode);
			balanceTopUpResponse.setDescription("ERROR");
		}
		BalanceTopUpWrapper.BALANCE_TOP_UP_RESPONSE = balanceTopUpResponse;
		
	}

	
}
