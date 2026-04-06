package com.email.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.email.dto.EmailDetails;
import com.email.service.EmailService;

@RestController
@RequestMapping("/api/contact")
public class EmailController {

	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	private EmailService emailService;

	public EmailController(EmailService emailService) {
		this.emailService = emailService;
	};

	@PostMapping
	public String sendMessage(@RequestBody EmailDetails form) {
		try {
			logger.info("sendMessage endpoint hit with: " + form);
			String sendSimpleMail = emailService.sendSimpleMail(form);
			logger.info(sendSimpleMail);
			return "Message sent successfully";
		} catch (Exception e) {
			return "Error sending message: " + e.getMessage();
		}
	}
}
