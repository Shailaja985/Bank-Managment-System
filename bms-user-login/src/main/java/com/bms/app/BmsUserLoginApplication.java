package com.bms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EntityScan("com.bms.app.*")
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class BmsUserLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsUserLoginApplication.class, args);
	}

}
