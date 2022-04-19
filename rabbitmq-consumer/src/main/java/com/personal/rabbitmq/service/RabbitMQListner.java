package com.personal.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListner implements MessageListener {
	
	 Logger logger = LoggerFactory.getLogger(RabbitMQListner.class);

	public void onMessage(Message message) {
		
		logger.info("Consuming Message - " + new String(message.getBody()));
	
	}
	
}