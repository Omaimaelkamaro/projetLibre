package com.example.notification.inerfaceFeignClient;

import com.example.notification.client.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", url = "http://localhost:9898/auth/email")
public interface UserFeignClient {

    @GetMapping("/{email}")
    UserDto getUserByEmail(@PathVariable ("email") String email);
}
