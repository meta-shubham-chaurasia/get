package com.example.MailSender;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailSenderConfig {
	
	@Bean("smtp")
	public SmtpMailSender getSmtpMail() {
		return new SmtpMailSender();
	}
	@Bean("mock")
	public MockMailSender getMockMail() {
		return new MockMailSender();
	}
}