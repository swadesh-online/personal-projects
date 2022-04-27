package com.personal.kafka.producer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	Logger logger = LoggerFactory.getLogger(ProducerService.class);
	
	public String topicName = "swadesh-topic";
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	
	public void publishMessage(String message) {
		
		logger.info("Producing to Topic : "+ topicName);
		
		kafkaTemplate.send(topicName, message);
		
	}
	
}
