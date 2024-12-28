package com.example.Analyse;

import  com.example.Analyse.client.LaboratoireDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "laboratoire-service", url = "http://localhost:5000/api/laboratoires")
public interface LaboratoireFeignClient {
    @GetMapping("/{id}")
    LaboratoireDTO getLaboratoireById(@PathVariable Long id);
}
