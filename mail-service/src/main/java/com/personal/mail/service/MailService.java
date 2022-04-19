package com.personal.mail.service;

import org.springframework.http.ResponseEntity;

public interface MailService {
	
	ResponseEntity<String> send();

}
