package com.example.servicess.servicess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServicessApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicessApplication.class, args);
	}

}
