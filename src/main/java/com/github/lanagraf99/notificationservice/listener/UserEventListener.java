package com.github.lanagraf99.notificationservice.listener;

import com.github.lanagraf99.notificationservice.dto.UserEvent;
import com.github.lanagraf99.notificationservice.servise.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {
    private final EmailService emailService;

    @Autowired
    public UserEventListener(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = "user-events")
    public void handleUserEvent(UserEvent event) {
        System.out.println("Получено событие из Kafka: " + event.getOperation()
        + " для " + event.getEmail());
        emailService.sendUserNotification(event.getEmail(), event.getOperation());
    }
}
