package com.example.MailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailSenderController {

	
	//@Qualifier("mock")
	@Autowired
	private MailSender mailsender;
	@Autowired
	//@Qualifier("smtp")
	/*public void setMail(MailSender mail) {
		this.mail=mail;
	}*/
	/*@Autowired
	public MailSenderController(MailSender mail) {
		this.mail=mail;

	}
*/
	@GetMapping("/home")
	public String send()
	{
		 
		 return mailsender.sendMail();
	}
	
}