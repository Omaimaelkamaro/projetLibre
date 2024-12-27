package com.example.userAuthentification.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Microservice API",
                version = "1.0",
                description = "Documentation de l'API de microservice",
                contact = @Contact(
                        name = "Support API",
                        email = "support@exemple.com"
                )
        )
)
@Configuration
public class SwaggerConfig {
    // Vous pouvez ajouter des configurations supplémentaires si nécessaire
    @Bean
    public GroupedOpenApi userAuthentificationApi() {
        return GroupedOpenApi.builder()
                .group("User Authentication Service")
                .pathsToMatch("/auth/**")
                .packagesToScan("com.example.userAuthentification.controller")
                .build();
    }
}
