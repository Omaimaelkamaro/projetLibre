package com.example.notification.controller;

import com.example.notification.client.UserDto;
import com.example.notification.service.EmailService;

import com.example.notification.dto.EmailRequest;

import com.example.notification.serviceClient.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private EmailService emailService;
    private UserService userService;


    @PostMapping("/email")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendEmail(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getBody());
        return ResponseEntity.ok("Email sent successfully!");
    }

   /* @PostMapping("/sms")
    public ResponseEntity<String> sendSms(@RequestBody SmsRequest smsRequest) {
        smsService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
        return ResponseEntity.ok("SMS sent successfully!");
    }*/
   public NotificationController(UserService userService){
       this.userService =userService;
   }

    @GetMapping("/auth/email/{email}")
    public String sendNotification(@PathVariable String email) {
        UserDto user = userService.getUserDetails(email);
        return "Notification envoyée à : " + user.getUsername() + " (" + user.getEmail() + ")";
    }
}

