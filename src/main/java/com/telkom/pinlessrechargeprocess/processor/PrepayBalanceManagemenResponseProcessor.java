package com.telkom.pinlessrechargeprocess.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUpResponse;
import com.telkom.pinlessrechargeprocess.utility.BalanceTopUpWrapper;

public class PrepayBalanceManagemenResponseProcessor implements Processor{

	Logger logger = LoggerFactory.getLogger(PrepayBalanceManagemenResponseProcessor.class);
	@Override
	public void process(Exchange exchange) throws Exception {
		
		logger.info("=========inside PrepayBalanceManagemenResponseProcessor=========");
		BalanceTopUpResponse balanceTopUpResponse = new BalanceTopUpResponse();
		//String responseCode = (String) exchange.getIn().getHeader(Exchange.HTTP_RESPONSE_CODE);
		String responseCode = "201";
		logger.info("====response code is ==="+ responseCode);
		if(responseCode.equalsIgnoreCase("201"))
		{
			balanceTopUpResponse.setCode("201");
			balanceTopUpResponse.setDescription("OK");
			exchange.getOut().setBody("201");
		}else
		{
			balanceTopUpResponse.setCode(responseCode);
			balanceTopUpResponse.setDescription("ERROR");
		}
		BalanceTopUpWrapper.BALANCE_TOP_UP_RESPONSE = balanceTopUpResponse;
		
	}

	
}
