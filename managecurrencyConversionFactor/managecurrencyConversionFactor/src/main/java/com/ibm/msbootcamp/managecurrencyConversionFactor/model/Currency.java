package com.ibm.msbootcamp.managecurrencyConversionFactor.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "currency")
public class Currency {
	
	@Id
	@Column(name = "countrycode", table = "currency")
	private String countryCode;
	@Column(name = "convFactor",table = "currency")
	private double convFactor;



	public Currency() {
		super();
	}
	public Currency(String countrycode, double convFactor)
	{
		super();
		this.countryCode = countrycode;
		this.convFactor = convFactor;
		
	}
	public double getConvFactor() {
		return convFactor;
	}
	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public void setConvFactor(double convFactor) {
		this.convFactor = convFactor;
	}

	
	
}
