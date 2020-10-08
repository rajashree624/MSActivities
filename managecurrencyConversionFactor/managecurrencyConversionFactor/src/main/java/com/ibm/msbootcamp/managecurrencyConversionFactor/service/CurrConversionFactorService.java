package com.ibm.msbootcamp.managecurrencyConversionFactor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.msbootcamp.managecurrencyConversionFactor.model.ConversionFactorResponse;
import com.ibm.msbootcamp.managecurrencyConversionFactor.model.Currency;
import com.ibm.msbootcamp.managecurrencyConversionFactor.model.CurrencyFactor;
import com.ibm.msbootcamp.managecurrencyConversionFactor.repository.CurrencyConversionRepository;

@Service
public class CurrConversionFactorService {
	
	@Autowired
	CurrencyConversionRepository repo;
	
	public void addConversionFactor(Currency curr ) {
		
			repo.save(curr);
			
	}	
	
	
//	public void updateConversionFactor(CurrencyFactor curr ) {
//		
//		Currency existingCurrencyConversion  = repo.findByCountryCode(curr.getCountryCode());
//		
//		if(curr.getCountryCode()!= null && curr.getCountryCode().length() >0)
//		{
//			if(existingCurrencyConversion!= null)
//			{
//				existingCurrencyConversion.setConvFactor(curr.getConvFactor());
//				repo.save(existingCurrencyConversion);
//				
//			}
//		}
public void updateConversionFactor(Currency curr ) {
				repo.save(curr);
		
}	

//public CurrencyFactor getConversionFactor(String inCountrycode) {
//	Currency existingCurrencyConversion  = repo.findByCountryCode(inCountrycode);
//	
//	CurrencyFactor newConversionFactor = new CurrencyFactor();
//	if(existingCurrencyConversion!= null)
//	{
//		newConversionFactor.setCountryCode(existingCurrencyConversion.getCountryCode());
//		newConversionFactor.setCountryCode(existingCurrencyConversion.getCountryCode());
//	}
//	// TODO Auto-generated method stub
//	return newConversionFactor;
//}

public Double getConversionFactor(String countryCode) {		
	Currency conversionFactor = repo.getOne(countryCode);
	double cf = conversionFactor.getConvFactor();
	System.out.println("getConversionFactor:"+cf);
	return cf;

}

public double convertCurrencyToRupee(String countryCode, double amount)
{
	double convFactor=getConversionFactor(countryCode);
	//return currencyConverterService.convertCurrencyToRupee(countryCode,amount);
	System.out.println(" ..convFactor  ms1:"+convFactor);
	CurrencyFactor currencyFactor = new CurrencyFactor();
	RestTemplate template = new RestTemplate();
	HttpEntity<CurrencyFactor> reqEntity = new HttpEntity<CurrencyFactor>(currencyFactor);
	HttpEntity<ConversionFactorResponse> conversionFactorResponse = template.exchange("", HttpMethod.POST, reqEntity, ConversionFactorResponse.class);
	ConversionFactorResponse convFactorResponse = conversionFactorResponse.getBody();
	//double convertedAmount = convFactorResponse.getAmount()*convFactorResponse.getConvFactor();
	System.out.println("converted amount" + convFactorResponse.getAmount());
	return convFactorResponse.getAmount();
	
	
}

}
