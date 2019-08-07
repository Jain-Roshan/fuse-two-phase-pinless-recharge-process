package com.telkom.pinlessrechargeprocess.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUpStatus;
import com.telkom.pinlessrechargeprocess.utility.BalanceTopUpWrapper;

public class TwoPhasePinlessRechargeProcessor implements Processor{

	ObjectMapper objectMapper = new ObjectMapper();
	Logger log = LoggerFactory.getLogger(TwoPhasePinlessRechargeProcessor.class);
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		log.info("=======inside TwoPhasePinlessRechargeProcessor =========");
		BalanceTopUp balanceTopUp = objectMapper.readValue(exchange.getIn().getBody(String.class), BalanceTopUp.class);
		log.info("======Type is "+ balanceTopUp.getType());
		BalanceTopUpWrapper.BALANCE_TOP_UP = balanceTopUp;
		
		BalanceTopUpStatus balanceTopUpStatus = new BalanceTopUpStatus();
		balanceTopUpStatus.setStatus("Wait for Recharge Completion");
		
		exchange.getIn().setBody(objectMapper.writeValueAsString(balanceTopUpStatus));
	}

	
}
