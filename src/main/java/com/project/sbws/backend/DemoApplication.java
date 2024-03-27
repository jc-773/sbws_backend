package com.project.sbws.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.project.sbws.backend.services.backendExternalRequestServices.interfaces.IBackendRequestService;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
//@ComponentScan("com.mysql.example.demo")
public class DemoApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
}
