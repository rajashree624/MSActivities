package com.ibm.msbootcamp.managecurrencyConversionFactor.model;

public class ConversionFactorResponse {
	
	private int status;
	private String message;	
	String countryCode;
	double conversionFactor;
	double amount;
	
	public ConversionFactorResponse(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ConversionFactorResponse(String countryCode, double conversionFactor,double amount,int status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.amount =amount;
	}
	public ConversionFactorResponse() {
		super();
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
