package com.telkom.pinlessrechargeprocess.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUpResponse;
import com.telkom.pinlessrechargeprocess.processor.BalanceTopUpProcessor;
import com.telkom.pinlessrechargeprocess.processor.ChangeSubscriberProcessor;
import com.telkom.pinlessrechargeprocess.processor.GetSubscriberProcessor;
import com.telkom.pinlessrechargeprocess.processor.PrepayBalanceManagemenResponseProcessor;
import com.telkom.pinlessrechargeprocess.processor.TwoPhasePinlessRechargeProcessor;
import com.telkom.pinlessrechargeprocess.utility.BalanceTopUpWrapper;

public class Route extends RouteBuilder{

	Logger log = LoggerFactory.getLogger(Route.class);
	ObjectMapper objectMapper = new ObjectMapper();
	@Override
	public void configure() throws Exception {
		
		log.info("=======inside Route =======");
		from("cxfrs://bean://restService").process(new TwoPhasePinlessRechargeProcessor())
		//Put call
		.process(new BalanceTopUpProcessor())
		.choice()
			.when()
				.simple("${header.Target} == 'PrepayBalanceManagement'")
				.to("direct:PrepayBalanceManagement")
			.when()
				.simple("${header.Target} == 'GetSubscriber'")
				.to("direct:GetSubscriber");
			
				
		
		from("direct:PrepayBalanceManagement")
		.log(" ==== Sending to Fuse PrepayBalanceManagement ==== ")
		/*.removeHeaders("*").removeProperties("*")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.to();*/
		.process(new PrepayBalanceManagemenResponseProcessor())
		.choice()
			.when()
			.simple("${body} == '201'")
			.to("direct:CRM")
		.otherwise()
		.log("===Call to PrepayBalanceManagement failed====")
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				exchange.getOut().setBody("Error while Calling PrepayBalanceManagement");
			}
		});
		
		
		from("direct:GetSubscriber")
		.log(" ==== Sending to GetSubscriber ==== ")
		/*.removeHeaders("*").removeProperties("*")
		.setHeader(Exchange.HTTP_METHOD, constant("GET"))
		.recipientList(simple("{{getsubscriber}}"
				+ "${body}?throwExceptionOnFailure=false"))*/
		.process(new GetSubscriberProcessor())
		.choice()
		.when()
			.simple("${header.Result} == 'Success'")
			.to("direct:ChangeSubscriberProducts");
		
		from("direct:ChangeSubscriberProducts")
		.log(" ==== Sending to ChangeSubscriberProducts ==== ")
		/*.removeHeaders("*").removeProperties("*")
		.setHeader(Exchange.HTTP_METHOD, constant("POST"))
		.setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
		.recipientList(simple("{{changesubscriberproductsservice}}"))*/
		.process(new ChangeSubscriberProcessor())
		.choice()
			.when()
				.simple("${body} == '200'")
				.to("direct:CRM")
			.otherwise()
				.log("===Call to ChangeSubscriberProducts failed====")
				.process(new Processor() {
		
					@Override
					public void process(Exchange exchange) throws Exception {
						exchange.getOut().setBody("Error while Calling ChangeSubscriberProducts");
					}
				});
		
		from("direct:CRM")
		.log("===Sending to CRM=======")
		//Set status to "Recharge Completion"
		//PUT/balanceTopUp/status
		//Get Response
		.process(new Processor() {
			
			@Override
			public void process(Exchange exchange) throws Exception {
				BalanceTopUpResponse balanceTopUpResponse = BalanceTopUpWrapper.BALANCE_TOP_UP_RESPONSE;
				exchange.getOut().setBody(objectMapper.writeValueAsString(balanceTopUpResponse));
			}
		});
		
	}

	
}
