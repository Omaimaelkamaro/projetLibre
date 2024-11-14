package com.example.userAuthentification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@EntityScan("com.example.userAuthentification.entity")
@EnableJpaRepositories("com.example.userAuthentification.repository")
@SpringBootApplication
public class UserAuthentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthentificationApplication.class, args);
	}

}
