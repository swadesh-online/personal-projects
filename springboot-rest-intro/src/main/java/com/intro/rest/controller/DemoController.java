package com.intro.rest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Bean
	RestTemplate restTemplate() {

		return new RestTemplate();
	}

	@GetMapping("/hello")
	public String hello() {

		return "hello";
	}

	@GetMapping("/dl/{age}")
	public String checkDl(@PathVariable int age) {

		if (age >= 18) {
			return "Eligible to Apply!";
		} else {
			return "Not Eligible to Apply!";
		}
	}

	@GetMapping("/weather/{cityName}")
	public ResponseEntity<Object> getWeatherDetails(@PathVariable String cityName) {

		String url = "http://api.weatherapi.com/v1/forecast.json?key=483a04daff914ce58f991903220803&q={city}&days={days}";
		try {
			ResponseEntity<Object> response = this.restTemplate().getForEntity(url, Object.class, cityName, "7");
			return response;
		} catch (HttpClientErrorException ex) {
			ex.printStackTrace();
		} catch (HttpServerErrorException ex) {
			ex.printStackTrace();
		}
		return null;
	
	}
	

}
