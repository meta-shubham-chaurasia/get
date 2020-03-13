package com.example.MailSender;

import org.springframework.stereotype.Component;

//@Component("smtp")
public class SmtpMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "smtp mail";
		
	}
	
	
}