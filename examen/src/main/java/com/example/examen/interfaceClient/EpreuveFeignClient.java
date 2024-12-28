package com.example.examen.interfaceClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.examen.client.EpreuveDTO;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "epreuve-service", url = "http://localhost:7000/api/epreuves")
public interface EpreuveFeignClient {



    @GetMapping("/{id}")
        EpreuveDTO   getEpreuveById(@PathVariable Long id);



}
