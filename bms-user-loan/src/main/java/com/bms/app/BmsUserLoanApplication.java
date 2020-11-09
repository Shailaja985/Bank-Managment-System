package com.bms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BmsUserLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsUserLoanApplication.class, args);
	}

}
