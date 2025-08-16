package com.BankManagement.Operations.Config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("users")  // Group name in Swagger UI
                .packagesToScan("com.BankManagement.Operations.Controller") // Scan your controller package
                .build();
    }
}
