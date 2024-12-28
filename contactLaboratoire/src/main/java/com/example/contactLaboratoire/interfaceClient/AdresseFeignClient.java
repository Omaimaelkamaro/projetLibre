package com.example.contactLaboratoire.interfaceClient;

import com.example.contactLaboratoire.client.AdresseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "adresse-service", url = "http://localhost:8010/api/adresses")
public interface AdresseFeignClient {

    @GetMapping("/{id}")
        AdresseDTO getAdresseById(@PathVariable Long id);
    }

