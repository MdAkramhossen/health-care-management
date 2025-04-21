package com.logrex.patient_management.exception;


import org.springframework.http.HttpStatus;


public class HealthCareApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public HealthCareApiException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HealthCareApiException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
