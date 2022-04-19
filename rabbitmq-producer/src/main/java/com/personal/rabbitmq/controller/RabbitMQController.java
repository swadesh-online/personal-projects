package com.personal.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.rabbitmq.model.Employee;
import com.personal.rabbitmq.service.RabbitMQSender;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {

	@Autowired
	RabbitMQSender rabbitMQSender;
	
	@GetMapping("/producer/{empId}/{empName}")
	public String producer(@PathVariable("empId") String empId, @PathVariable("empName") String name) {
		
		Employee emp = new Employee();
		emp.setEmpId(empId);
		emp.setName(name);
		
		rabbitMQSender.send(emp);
		
		return "Message sent successfully!";
	}
}
