package com.ibm.msbootcamp.currencyconversionms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorRequest;
import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorResponse;
import com.ibm.msbootcamp.currencyconversionms.service.CurrencyConverterService;

@RestController
@RequestMapping(path = "/currencyconverter")
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyConverterService currencyConverterService;
	
	@RequestMapping(path = "/convCurr",  method = RequestMethod.POST)
	public double convertCurrencyToRupee(@RequestBody ConversionFactorRequest aCurrencyFactor)
	{
		double convFactor = getConvFactor(aCurrencyFactor.getCountryCode());
		RestTemplate template = new RestTemplate();
		double convertedAmount = convFactor*aCurrencyFactor.getAmount();
		return convertedAmount;
		
	}
	public double getConvFactor(String countryCode) {
		double tmpConvFactor=0;
		if(countryCode.equals("USD")) {
			tmpConvFactor = 75;
			}
		else if(countryCode.equals("EUR")){
			tmpConvFactor =85;
		}
		else if(countryCode.equals("BLR")){
			tmpConvFactor = 18;
		}
		return tmpConvFactor;
	}
		
	@GetMapping(path = "/convCurr1")
	public double convertCurrencyToRupeeC1(@RequestBody ConversionFactorRequest aCurrencyFactor)
	{
		String countryCode = aCurrencyFactor.getCountryCode();
		
		System.out.println("call to convCurr1");
		double convertedAmount = currencyConverterService.convertCurrencyToRupeeC1(aCurrencyFactor);
		return convertedAmount;
		
	}
	
	//Calling MS with discoveryclient
	@GetMapping(path = "/convCurr2")
	public double convertCurrencyToRupeeC2(@RequestBody ConversionFactorRequest aCurrencyFactor)
	{
		System.out.println("call to convCurr2");
		double convertedAmount = currencyConverterService.convertCurrencyToRupeeC2(aCurrencyFactor);
		return convertedAmount;
	}
	
	//Calling MS with loadbalanced client
	@GetMapping(path = "/convCurr3")
	public double convertCurrencyToRupeeC3(@RequestBody ConversionFactorRequest aCurrencyFactor)
	{
		System.out.println("call to convCurr3");
		double convertedAmount = currencyConverterService.convertCurrencyToRupeeC3(aCurrencyFactor);
		return convertedAmount;
	}
	
	//Calling MS with loadbalanced rest template
	@GetMapping(path = "/convCurr4")
	public double convertCurrencyToRupeeC4(@RequestBody ConversionFactorRequest aCurrencyFactor)
	{
		System.out.println("call to convCurr4");
		double convertedAmount = currencyConverterService.convertCurrencyToRupeeC4(aCurrencyFactor);
		return convertedAmount;
	}
	
	//Calling MS with feign client
	@GetMapping(path = "/convCurr5")
	public String convertCurrencyToRupeeC5(@RequestBody ConversionFactorRequest aCurrencyFactor)
	{
		System.out.println("call to convCurr5");
		String countryCode = aCurrencyFactor.getCountryCode();
		double convertedAmount = currencyConverterService.convertCurrencyToRupeeC5(aCurrencyFactor);
		if(convertedAmount==0) {
			return " Service is down Please check with  help desk ";
		}else
		{
		return " The converted amount is " +convertedAmount;
		}
	}
}	
