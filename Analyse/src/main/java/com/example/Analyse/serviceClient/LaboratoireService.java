package com.example.Analyse.serviceClient;

import com.example.Analyse.LaboratoireFeignClient;
import com.example.Analyse.client.LaboratoireDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LaboratoireService {

    private final LaboratoireFeignClient laboratoireFeignClient;

    @Autowired
    public LaboratoireService(LaboratoireFeignClient laboratoireFeignClient) {
        this.laboratoireFeignClient = laboratoireFeignClient;
    }

    public LaboratoireDTO getLaboratoireDetails(Long laboratoireId) {
        return laboratoireFeignClient.getLaboratoireById(laboratoireId);
    }
}
