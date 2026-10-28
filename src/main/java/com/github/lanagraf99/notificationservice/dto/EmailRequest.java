package com.github.lanagraf99.notificationservice.dto;

public class EmailRequest {
    private String email;
    private Operation operation;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Operation getOperation() {
        return operation;
    }
    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}
