 package mx.com.gnp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
  * Class SimpleEmailController.
  */
 @Slf4j
 @RestController
 @RequestMapping(value = "/email") 
public class SimpleEmailController {
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	
	@GetMapping(value = "/sendEmail")
	public String sendEmail() {
		log.info("sendEmail() >>>>>");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("miguetheking53@gmail.com");
		message.setSubject("SpringBoot application");
		message.setText("Hi How are you");
		
		javaMailSender.send(message);
		log.info("Successfulll sent email");
		return "Successfulll sent email";
	}
	
	// http://localhost:8890/email/sendEmail
	// NOTE:  URL Video - https://www.youtube.com/watch?v=mZM-E3m9GIs&list=LLfusw13hrRGthQVMjQ5dKNQ&index=2&ab_channel=JavaExpress

}
