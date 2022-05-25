package com.personal.kafka.consumer.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.personal.kafka.consumer.dto.EmailDto;

@Service
public class ConsumerService {
	Logger logger = LoggerFactory.getLogger(ConsumerService.class);

	@Bean
	RestTemplate restTemplate() {

		return new RestTemplate();
	}

	@KafkaListener(topics = "swadesh-topic", groupId = "my-group")
	public void consumeMessage(String message) {

		logger.info("Message Consumed..." + message);
		try {
			// call email Service

			final EmailDto emailDto = new EmailDto();
			emailDto.setFrom("hr@cybercity.in");
			emailDto.setTo("employee@cybercity.in");
			emailDto.setSubject("Notification from HR Dept, Cybercity");
			emailDto.setContent(message);

			callEmailService(emailDto);
		} catch (Exception ex) {
			logger.error("Ex: " + ex.getMessage());
		}
	}

	@Async
	public CompletableFuture<Void> callEmailService(EmailDto emailDto) {

		logger.info("Calling Email Service...");

		final String msgServiceUrl = "http://localhost:9567/email/send";

		final Void response = this.restTemplate().postForObject(msgServiceUrl, emailDto, Void.class);

		return CompletableFuture.completedFuture(response);
	}

}
