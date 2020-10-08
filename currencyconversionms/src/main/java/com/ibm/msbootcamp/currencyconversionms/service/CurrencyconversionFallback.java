package com.ibm.msbootcamp.currencyconversionms.service;

import org.springframework.stereotype.Component;

import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorRequest;
import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorResponse;

@Component
public class CurrencyconversionFallback implements CurrencyconversionFeignClient{
	
	@Override
	public ConversionFactorResponse getConversionFactor(ConversionFactorRequest request) {
		// TODO Auto-generated method stub
		
		return new ConversionFactorResponse("",0,request.getAmount(),1,"from fallback");
	}

}
