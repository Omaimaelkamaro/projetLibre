package com.example.userAuthentification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableDiscoveryClient

@EntityScan("com.example.userAuthentification.entity")
@EnableJpaRepositories("com.example.userAuthentification.repository")
@EnableFeignClients(basePackages = "com.example.userAuthentification")
@SpringBootApplication
public class UserAuthentificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserAuthentificationApplication.class, args);
	}

}
