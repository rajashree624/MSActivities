package com.ibm.msbootcamp.managecurrencyConversionFactor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.msbootcamp.managecurrencyConversionFactor.model.Currency;

@Repository
public interface CurrencyConversionRepository  extends JpaRepository<Currency, String> {
	
//	@Query("select convFactor from currency curr where curr.countryCode = ?1")
//	Currency findByCountryCode(@Param("countrycode") String inCountryCode);
}
