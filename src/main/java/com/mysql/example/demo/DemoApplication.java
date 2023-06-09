package com.mysql.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
//@ComponentScan("com.mysql.example.demo")
public class DemoApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}



	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// testRepository.save(new Player("Stephen"));
	// }
}
