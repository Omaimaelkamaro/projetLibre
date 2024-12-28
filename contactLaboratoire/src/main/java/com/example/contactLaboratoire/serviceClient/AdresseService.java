package com.example.contactLaboratoire.serviceClient;


import com.example.contactLaboratoire.client.AdresseDTO;
import com.example.contactLaboratoire.interfaceClient.AdresseFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdresseService {
    private final AdresseFeignClient adresseFeignClient;

    // Correct constructor without return type

    @Autowired
    public AdresseService(AdresseFeignClient adresseFeignClient) {
        this.adresseFeignClient = adresseFeignClient;
    }

        public AdresseDTO getAdresseDetails(Long adresseId) {
            return adresseFeignClient.getAdresseById(adresseId);
        }

}
