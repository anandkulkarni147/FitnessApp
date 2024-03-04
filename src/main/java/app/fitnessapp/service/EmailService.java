package app.fitnessapp.service;

import javax.mail.MessagingException;

public interface EmailService {
    void sendOtpEmail(String toEmail, String otp) throws MessagingException;
}
