package com.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.dto.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String recipient;

	public EmailServiceImpl(JavaMailSender javamaMailSender) {
		this.javaMailSender = javamaMailSender;
	}

	@Override
	public String sendSimpleMail(EmailDetails details) {
		logger.info("sending email to " + recipient);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(details.getEmail());
		message.setTo(recipient);
		message.setSubject(details.getSubject());
		message.setText("From: " + details.getName() + " <" + 
		details.getEmail() + ">\n\n" + details.getMessage());

		javaMailSender.send(message);
		return "Mail Sent Successfully";

	}

	@Override
	public String sendMailWithAttachment(EmailDetails details) {
		// TODO Auto-generated method stub
		return null;
	}

}
