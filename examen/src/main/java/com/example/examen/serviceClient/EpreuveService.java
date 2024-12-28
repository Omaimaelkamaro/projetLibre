package com.example.examen.serviceClient;


import com.example.examen.client.EpreuveDTO;
import com.example.examen.interfaceClient.EpreuveFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class EpreuveService {




        private final EpreuveFeignClient epreuveFeignClient;

        @Autowired
        public EpreuveService(EpreuveFeignClient epreuveFeignClient) {
            this.epreuveFeignClient = epreuveFeignClient;
        }

        public EpreuveDTO getEpreuveDetails(Long Id) {
            return epreuveFeignClient.getEpreuveById(Id);
        }


}

