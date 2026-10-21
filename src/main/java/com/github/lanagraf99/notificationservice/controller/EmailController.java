package com.github.lanagraf99.notificationservice.controller;

import com.github.lanagraf99.notificationservice.dto.EmailRequest;
import com.github.lanagraf99.notificationservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequest request) {
        emailService.sendUserNotification(request.getEmail(), request.getOperation());
        return "Письмо отправлено на " + request.getEmail();
    }
}
