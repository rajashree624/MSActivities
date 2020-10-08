package com.ibm.msbootcamp.currencyconversionms.model;

public class ConversionFactorRequest {
	
	String countryCode;
	double conversionFactor;
	double amount;
	
	public ConversionFactorRequest(String countryCode, double conversionFactor,double amount) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.amount =amount;
	}
	public ConversionFactorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	
	public double getConvFactor() {
		return conversionFactor;
	}
	public void setConvFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	

}
