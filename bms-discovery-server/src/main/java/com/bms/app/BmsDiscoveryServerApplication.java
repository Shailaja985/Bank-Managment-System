package com.bms.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BmsDiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BmsDiscoveryServerApplication.class, args);
	}

}
