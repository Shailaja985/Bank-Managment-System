package com.bms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class BmsUserRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsUserRegisterApplication.class, args);
	}
	
	
}
