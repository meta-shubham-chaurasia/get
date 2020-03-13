package com.example.MailSender;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("mock")
//@Primary
public class MockMailSender implements MailSender {

	@Override
	public String sendMail() {
		return "write mail to console";
		
	}

}