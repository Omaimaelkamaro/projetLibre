package com.example.Epreuve.interfaceClient;


import com.example.Epreuve.client.AnalyseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "analyse-service", url = "http://localhost:5010/api/analyses")
public interface AnalyseFeignClient {

    @GetMapping("/{id}")
        AnalyseDto   getAnalyseById(@PathVariable Long id);

}
