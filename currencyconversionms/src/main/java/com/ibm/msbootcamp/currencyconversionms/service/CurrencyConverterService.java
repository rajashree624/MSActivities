package com.ibm.msbootcamp.currencyconversionms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorRequest;
import com.ibm.msbootcamp.currencyconversionms.model.ConversionFactorResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CurrencyConverterService {
	
	
@Autowired
DiscoveryClient discoveryClient;

@Autowired
RestTemplate lbRestTemplate;

@Autowired
LoadBalancerClient lbClient;

@Autowired
CurrencyconversionFeignClient feignClient;


@Bean
@LoadBalanced
RestTemplate getRestTemplate()
{
	return new RestTemplate();
}

public double convertCurrencyToRupeeC1(ConversionFactorRequest aCurrencyFactor)
{
	System.out.println("in convertCurrencyToRupeeC1");
	String countryCode = aCurrencyFactor.getCountryCode();
	String url = "http://localhost:8001/conversionFactor";
	RestTemplate restTemplate = new RestTemplate();
	
	HttpEntity<ConversionFactorRequest> aCurrencyEntity = new HttpEntity<ConversionFactorRequest>(aCurrencyFactor);
	HttpEntity<ConversionFactorResponse> aCurrencyEntityResponse = restTemplate.exchange(url, HttpMethod.POST, aCurrencyEntity, ConversionFactorResponse.class);
	ConversionFactorResponse response = aCurrencyEntityResponse.getBody();
	double convertedAmount = response.getConvFactor()*response.getAmount();
	return convertedAmount;
	
}	
public double convertCurrencyToRupeeC2(ConversionFactorRequest aCurrencyFactor)
{
	System.out.println("in convertCurrencyToRupeeC2");
	String countryCode = aCurrencyFactor.getCountryCode();
	
	List<ServiceInstance> instances = discoveryClient.getInstances("manageCurrConversionFactorms");
	ServiceInstance instance = instances.get(0);				
	String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/conversionFactor";
	RestTemplate restTemplate = new RestTemplate();
	
	HttpEntity<ConversionFactorRequest> aCurrencyEntity = new HttpEntity<ConversionFactorRequest>(aCurrencyFactor);
	HttpEntity<ConversionFactorResponse> aCurrencyEntityResponse = restTemplate.exchange(url, HttpMethod.POST, aCurrencyEntity, ConversionFactorResponse.class);
	ConversionFactorResponse response = aCurrencyEntityResponse.getBody();
	double convertedAmount = response.getConvFactor()*response.getAmount();
	return convertedAmount;
	
}

public double convertCurrencyToRupeeC3(ConversionFactorRequest aCurrencyFactor)
{
	System.out.println("in convertCurrencyToRupeeC3");
	String countryCode = aCurrencyFactor.getCountryCode();
	
	ServiceInstance instance = lbClient.choose("manageCurrConversionFactorms");
	
	String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/conversionFactor";
	RestTemplate restTemplate = new RestTemplate();
	
	HttpEntity<ConversionFactorRequest> aCurrencyEntity = new HttpEntity<ConversionFactorRequest>(aCurrencyFactor);
	HttpEntity<ConversionFactorResponse> aCurrencyEntityResponse = restTemplate.exchange(url, HttpMethod.POST, aCurrencyEntity, ConversionFactorResponse.class);
	ConversionFactorResponse response = aCurrencyEntityResponse.getBody();
	double convertedAmount = response.getConvFactor()*response.getAmount();
	return convertedAmount;
	
}
@HystrixCommand(fallbackMethod = "getConvFactorFallback")
public double convertCurrencyToRupeeC4(ConversionFactorRequest aCurrencyFactor)
{
	System.out.println("in convertCurrencyToRupeeC4");
	String url = "http://manageCurrConversionFactorms/conversionFactor";
	HttpEntity<ConversionFactorRequest> aCurrencyEntity = new HttpEntity<ConversionFactorRequest>(aCurrencyFactor);
	HttpEntity<ConversionFactorResponse> aCurrencyEntityResponse = lbRestTemplate.exchange(url, HttpMethod.POST, aCurrencyEntity, ConversionFactorResponse.class);
	ConversionFactorResponse response = aCurrencyEntityResponse.getBody();
	double convertedAmount = response.getConvFactor()*response.getAmount();
	return convertedAmount;
	
}
	
public double convertCurrencyToRupeeC5(ConversionFactorRequest aCurrencyFactor)
{
	System.out.println("in convertCurrencyToRupeeC5");
	ConversionFactorResponse response = feignClient.getConversionFactor(aCurrencyFactor);
	System.out.println("out convertCurrencyToRupeeC5");
	double convertedAmount = response.getConvFactor()*response.getAmount();
	return convertedAmount;
	
}

public double getConvFactorFallback(ConversionFactorRequest aCurrencyFactor) {

	return 6;
}

}
