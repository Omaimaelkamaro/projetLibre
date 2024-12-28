package com.example.Analyse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients(basePackages = "com.example.Analyse")
@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories("com.example.Analyse.repository") // Ajustez le chemin
@EntityScan("com.example.Analyse.entity")
public class AnalyseApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyseApplication.class, args);
	}

}
