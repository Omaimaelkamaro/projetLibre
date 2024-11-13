package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EntityScan("com.example.entities")
@EnableJpaRepositories("com.example.repository")
@SpringBootApplication
public class UtilisateurApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilisateurApplication.class, args);
    }

}