package com.example.examen.interfaceClient;

import com.example.examen.client.DossierDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "dossier-service", url = "http://localhost:8090/api/dossiers")
public interface DossierFeignClient {

    @GetMapping("/{id}")
    DossierDTO  getDossierByNumDossier(@PathVariable Long id);


}
