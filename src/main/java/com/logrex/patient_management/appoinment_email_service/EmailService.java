package com.logrex.patient_management.appoinment_email_service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendAppointmentScheduledEmail(String to, String patientName, LocalDateTime dateTime) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Appointment Scheduled");
        message.setText("Hello " + patientName + ",\n\nYour appointment has been scheduled for " +
                dateTime.toString() + ".\n\nThank you!");

        mailSender.send(message);
    }
}
