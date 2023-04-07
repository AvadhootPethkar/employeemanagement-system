package com.avd.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class EmployeeServiceApplication {

/*
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
*/

/*
	// Step 2 : For Wen Client
	@Bean
	public WebClient webClient() {
		return WebClient.builder().build();
	}
*/

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
