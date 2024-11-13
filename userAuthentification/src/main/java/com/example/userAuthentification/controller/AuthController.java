package com.example.userAuthentification.controller;

import com.example.userAuthentification.dto.JwtAuthenticationResponse;
import com.example.userAuthentification.entity.User;
import com.example.userAuthentification.service.JwtTokenProvider;
import com.example.userAuthentification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String addNewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody JwtAuthenticationResponse authRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authenticate.isAuthenticated()) {
            return userService.generateToken(authRequest.getUsername());
        } else {
            throw new RuntimeException("invalid access");
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        userService.validateToken(token);
        return "Token is valid";
    }
}

