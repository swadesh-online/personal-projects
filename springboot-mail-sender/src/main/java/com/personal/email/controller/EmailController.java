package com.personal.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.email.dto.EmailDto;
import com.personal.email.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<Object> sendEmail(@RequestBody EmailDto emailDto){
		
		emailService.sendEmail(emailDto.getTo(), emailDto.getFrom(), emailDto.getSubject(), emailDto.getContent());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
