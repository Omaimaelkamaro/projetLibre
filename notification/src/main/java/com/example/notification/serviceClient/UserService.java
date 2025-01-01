package com.example.notification.serviceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.notification.inerfaceFeignClient.UserFeignClient;
import com.example.notification.client.UserDto;


@Service
public class UserService {

    private final UserFeignClient userFeignClient;

    @Autowired
    public UserService(UserFeignClient userFeignClient) {
        this.userFeignClient = userFeignClient;
    }

    public UserDto getUserDetails(String email) {
        return userFeignClient.getUserByEmail(email);
    }
}

