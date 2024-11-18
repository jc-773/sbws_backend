package com.project.sbws.backend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
    
    @Bean
     public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("NBA Stats API")
                        .version("0.0.1")
                        .description("Documentation for the #1 NBA stats API"));
    }
}
