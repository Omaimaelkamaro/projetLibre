package com.example.Epreuve.serviceClient;

import com.example.Epreuve.interfaceClient.AnalyseFeignClient;
import com.example.Epreuve.client.AnalyseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnalyseService {

    private final AnalyseFeignClient analyseFeignClient;

    @Autowired
    public AnalyseService(AnalyseFeignClient analyseFeignClient) {
        this.analyseFeignClient = analyseFeignClient;
    }

    public AnalyseDto getAnalyseDetails(Long Id) {
        return analyseFeignClient.getAnalyseById(Id);
    }
}
