package com.personal.kafka.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.kafka.producer.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class ProducerController {
	
	@Autowired
	ProducerService producerService;

	@PostMapping("/send/{msg}")
	public void publishMessage(@PathVariable("msg") String message) {
		
		producerService.publishMessage(message);
		
	}
}
