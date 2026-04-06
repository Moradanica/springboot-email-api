package com.email.service;

import com.email.dto.EmailDetails;

public interface EmailService {
	 // Method to send simple email
    String sendSimpleMail(EmailDetails details);

    // Method to send email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
