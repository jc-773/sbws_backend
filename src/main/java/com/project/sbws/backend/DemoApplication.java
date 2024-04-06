package com.project.sbws.backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import com.project.sbws.backend.services.implementation.NBAPlayerStatsService;
import com.project.sbws.backend.services.implementation.requests.NBAPlayerRequestService;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
@EnableCaching
//@ComponentScan("com.mysql.example.demo")
public class DemoApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public NBAPlayerStatsService nBAPlayerStatsService() {
		return new NBAPlayerStatsService();
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	
}
