package com.ibm.msbootcamp.currencyconversionms.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorRequest;
import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorResponse;

@FeignClient(name = "manageCurrConversionFactorms",fallback = CurrencyconversionFallback.class)
public interface CurrencyconversionFeignClient {

	@RequestMapping(path = "/currencyfactor/conversionFactor", method = RequestMethod.POST)
	public ConversionFactorResponse getConversionFactor(ConversionFactorRequest request);
}
