package com.example.contactLaboratoire.serviceClient;

import com.example.contactLaboratoire.interfaceClient.LaboratoireFeignClient;
import com.example.contactLaboratoire.client.LaboratoireDTO;
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


