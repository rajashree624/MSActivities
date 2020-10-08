package com.ibm.msbootcamp.managecurrencyConversionFactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ManagecurrencyConversionFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagecurrencyConversionFactorApplication.class, args);
	}

}
