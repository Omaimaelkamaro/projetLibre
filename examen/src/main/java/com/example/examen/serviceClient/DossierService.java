package com.example.examen.serviceClient;

import com.example.examen.client.DossierDTO;
import com.example.examen.client.EpreuveDTO;
import com.example.examen.interfaceClient.DossierFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class DossierService {
    private final DossierFeignClient dossierFeignClient;

    @Autowired
    public DossierService(DossierFeignClient dossierFeignClient) {
        this.dossierFeignClient = dossierFeignClient;
    }

    public DossierDTO getDossierDetails(Long Id) {
        return dossierFeignClient.getDossierByNumDossier(Id);
    }

}
