package com.example.Epreuve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "com.example.Epreuve")
@EnableDiscoveryClient
@SpringBootApplication
public class EpreuveApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpreuveApplication.class, args);
	}

}
