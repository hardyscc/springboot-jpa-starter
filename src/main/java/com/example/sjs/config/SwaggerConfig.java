package com.example.sjs.config;

import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(BuildProperties buildProperties) {
        return new OpenAPI().info(new Info()
                .title("Demo JPA project for Spring Boot")
                .version(buildProperties.getVersion()));
    }
}