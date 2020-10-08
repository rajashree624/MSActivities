package com.ibm.msbootcamp.managecurrencyConversionFactor.model;

public class CurrencyFactor {
	
	String countryCode;
	double conversionFactor;
	double amount;
	
	public CurrencyFactor(String countryCode, double conversionFactor,double amount) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.amount =amount;
	}
	public CurrencyFactor() {
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
		return conversionFactor;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	
	public double getConvFactor() {
		return amount;
	}
	public void setConvFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	

}
