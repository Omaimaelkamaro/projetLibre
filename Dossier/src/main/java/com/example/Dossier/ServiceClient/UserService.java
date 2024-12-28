package com.example.Dossier.ServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Dossier.InterfaceFeignClient.UserFeignClient;
import com.example.Dossier.client.UserDTO;


    @Service
    public class UserService {

            private final UserFeignClient userFeignClient;

            @Autowired
            public UserService(UserFeignClient userFeignClient) {
                this.userFeignClient = userFeignClient;
            }

            public UserDTO getUserDetails(Long Id) {
                return userFeignClient.getUserById(Id);
            }
        }
