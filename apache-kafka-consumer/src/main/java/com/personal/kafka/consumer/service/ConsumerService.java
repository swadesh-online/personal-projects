package com.personal.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
	Logger logger = LoggerFactory.getLogger(ConsumerService.class);
	
	@KafkaListener(topics ="swadesh-topic", groupId="my-group")
	public void consumeMessage(String message) {
		
	logger.info("Message Consumed..." + message);
		
	}
	
}
