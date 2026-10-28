package com.github.lanagraf99.notificationservice.service;

import com.github.lanagraf99.notificationservice.dto.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendUserNotification(String email, Operation operation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Уведомление");

        String text = switch (operation) {
            case CREATE -> "Здравствуйте! Ваш аккаунт на сайте был успешно создан.";
            case DELETE -> "Здравствуйте! Ваш аккаунт был удален.";
        };

        message.setText(text);
        mailSender.send(message);
        log.info("Письмо отправлено на {} ({})", email, operation);
    }
}
