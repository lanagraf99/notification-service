package com.github.lanagraf99.notificationservice.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendUserNotification(String email, String operation) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Уведомление");

        String text;
        if ("CREATE".equals(operation)) {
            text = "Здравствуйте! Ваш аккаунт на сайте был успешно создан.";
        } else if ("DELETE".equals(operation)) {
            text = "Здравствуйте! Ваш аккаунт был удален.";
        } else {
            System.out.println("Неизвестная операция: " + operation);
            return;
        }

        message.setText(text);
        mailSender.send(message);
        System.out.println("Письмо отправлено на " + email + " (" + operation + ")");
    }
}
