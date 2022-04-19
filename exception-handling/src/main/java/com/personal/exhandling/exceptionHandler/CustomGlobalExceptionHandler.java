package com.personal.exhandling.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.personal.exhandling.exception.FutureDateException;
import com.personal.exhandling.exception.VeryEarlyDateException;
import com.personal.exhandling.model.ErrorMessage;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {
	
	@ExceptionHandler(value={VeryEarlyDateException.class})
	public ErrorMessage handleVeryEarlyDateException(VeryEarlyDateException ex) {
		
		ErrorMessage msg = new ErrorMessage();
		
		msg.setMessage("Very early Date! Select from 1922 to 2022.");
		msg.setTimestamp(new Date().getTime());
		msg.setStatus(HttpStatus.BAD_REQUEST);
		msg.setStatusCode(msg.getStatus().value());
	
		return msg;
	}
	

	@ExceptionHandler(value={FutureDateException.class})
	public ErrorMessage handleFutureDataException(FutureDateException ex) {
		ErrorMessage msg = new ErrorMessage();
		
		msg.setMessage("Welcome to Future! Select from 1922 to 2022.");
		msg.setTimestamp(new Date().getTime());
		msg.setStatus(HttpStatus.NOT_ACCEPTABLE);
		msg.setStatusCode(msg.getStatus().value());
	
		return msg;
	}



}
