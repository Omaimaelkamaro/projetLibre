package com.example.Dossier.InterfaceFeignClient;

import com.example.Dossier.client.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "user-service", url = "http://localhost:9898/auth")
public interface UserFeignClient {

    @GetMapping("/{id}")
    UserDTO  getUserById(@PathVariable Long id);

}
