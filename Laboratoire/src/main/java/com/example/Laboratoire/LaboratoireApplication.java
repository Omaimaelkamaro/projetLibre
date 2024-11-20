package com.example.Laboratoire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class LaboratoireApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboratoireApplication.class, args);
	}

}
