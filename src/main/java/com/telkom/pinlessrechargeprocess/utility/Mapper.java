package com.telkom.pinlessrechargeprocess.utility;

import java.util.ArrayList;
import java.util.List;

import com.telkom.pinlessrechargeprocess.balanceadjustment.Amount;
import com.telkom.pinlessrechargeprocess.balanceadjustment.PostBalanceAdjustment;
import com.telkom.pinlessrechargeprocess.balanceadjustment.Product;
import com.telkom.pinlessrechargeprocess.balancetopup.BalanceTopUp;
import com.telkom.pinlessrechargeprocess.logicalResourceInventory.Characteristic;
import com.telkom.pinlessrechargeprocess.logicalResourceInventory.LogicalResourceInventory;
import com.telkom.pinlessrechargeprocess.productorder.PostProductOrder;

public class Mapper {

	public static PostBalanceAdjustment mapFromBalanceTopUpToBalanceAdjustment(BalanceTopUp balanceTopUp) {
		PostBalanceAdjustment balanceAdjustment = new PostBalanceAdjustment();
		Product product = new Product();
		Amount amount = new Amount();
		List<com.telkom.pinlessrechargeprocess.balanceadjustment.Characteristic> characteristicList = new ArrayList<>();
		com.telkom.pinlessrechargeprocess.balanceadjustment.Characteristic characteristic = new com.telkom.pinlessrechargeprocess.balanceadjustment.Characteristic();
		if(null != balanceTopUp)
		{
			balanceAdjustment.setType(balanceTopUp.getType());
			if(null != balanceTopUp.getProduct())
				product.setId(balanceTopUp.getProduct().getId());
			if(null != balanceTopUp.getAmount())
				amount.setAmount(balanceTopUp.getAmount().getAmount());
			if(null != balanceTopUp.getChannel())
			{
				characteristic.setValue(balanceTopUp.getChannel().getId());
				characteristic.setName("requestorid");
				characteristicList.add(characteristic);
			}
			
		}

		balanceAdjustment.setProduct(product);
		balanceAdjustment.setAmount(amount);
		balanceAdjustment.setCharacteristic(characteristicList);
		
		return balanceAdjustment;
	}

	public static LogicalResourceInventory mapFromBalanceTopUpToLogicalResourceInventory(BalanceTopUp balanceTopUp) {
		//TODO: Map Response.logicalResource.value to logicalResource.value
		
		LogicalResourceInventory logicalResourceInventory = new LogicalResourceInventory();
		List<Characteristic> characteristicList = new ArrayList<>();
		
		Characteristic characteristic1 = new Characteristic();
		characteristic1.setName("isRatePlan");
		characteristic1.setValue("True");
		characteristicList.add(characteristic1);
		
		Characteristic characteristic2 = new Characteristic();
		characteristic2.setName("isValidNextBillCycle");
		characteristic2.setValue("False");
		characteristicList.add(characteristic2);
		
		Characteristic characteristic3 = new Characteristic();
		characteristic3.setName("Action");
		characteristic3.setValue("Add");
		characteristicList.add(characteristic3);
		
		if(null != balanceTopUp.getCharacteristic())
		{
			for(com.telkom.pinlessrechargeprocess.balancetopup.Characteristic balanceTopUpCharacteristic :balanceTopUp.getCharacteristic())
			{
				if(balanceTopUpCharacteristic.getName().equalsIgnoreCase("ServicePackCode"))
				{
					Characteristic characteristic4 = new Characteristic();
					characteristic4.setName("ServicePackCode");
					characteristic4.setValue(balanceTopUpCharacteristic.getValue());
					
					characteristicList.add(characteristic4);
				}
			}
		}
		
		logicalResourceInventory.setCharacteristic(characteristicList);
		return logicalResourceInventory;
	}

	

	
}
