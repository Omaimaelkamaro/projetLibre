package com.example.contactLaboratoire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.example.contactLaboratoire")
@SpringBootApplication
public class ContactLaboratoireApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactLaboratoireApplication.class, args);
	}

}
