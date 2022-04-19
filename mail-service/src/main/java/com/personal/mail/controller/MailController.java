package com.personal.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.mail.service.MailService;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	MailService mailService;
	
	@GetMapping("/send")
	public ResponseEntity<String> send() {
		
		return mailService.send();
		
	}

}
