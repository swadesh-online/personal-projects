package com.personal.exhandling.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

	private long timestamp;
	private String message;
	private HttpStatus status;
	private int statusCode;
	
}
