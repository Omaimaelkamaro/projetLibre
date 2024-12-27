package com.example.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
//
//    @Bean
//    public GroupedOpenApi userAuthentificationApi() {
//        return GroupedOpenApi.builder()
//                .group("User Authentication Service")
//                .pathsToMatch("/auth/**")
//                .packagesToScan("com.example.userAuthentification.controller")
//                .build();
//    }
//
////    @Bean
////    public GroupedOpenApi api() {
////        return GroupedOpenApi.builder()
////                .group("All APIs")
////                .pathsToMatch("/**")  // Cela va correspondre à toutes les routes de l'API
////                .build();
////    }
//
//
//
//    @Bean
//    public GroupedOpenApi adresseServiceApi() {
//        return GroupedOpenApi.builder()
//                .group("Adresse Service")
//                .pathsToMatch("/api/adresses/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi laboratoireServiceApi() {
//        return GroupedOpenApi.builder()
//                .group("Laboratoire Service")
//                .pathsToMatch("/api/laboratoires/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi epreuveServiceApi() {
//        return GroupedOpenApi.builder()
//                .group("Epreuve Service")
//                .pathsToMatch("/api/epreuve/**")
//                .build();
//    }
//
//    @Bean
//    public GroupedOpenApi analyseServiceApi() {
//        return GroupedOpenApi.builder()
//                .group("Analyse Service")
//                .pathsToMatch("/api/analyses/**")
//                .build();
//    }
@Bean
public GroupedOpenApi allMicroservicesApi() {
    return GroupedOpenApi.builder()
            .group("all-microservices")  // Nom du groupe, vous pouvez le personnaliser
            .pathsToMatch("/v3/api-docs/**")  // Match tous les endpoints Swagger de vos microservices
            .build();
}
}