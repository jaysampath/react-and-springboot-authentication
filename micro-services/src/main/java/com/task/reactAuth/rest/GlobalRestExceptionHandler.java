package com.task.reactAuth.rest;

import java.text.SimpleDateFormat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalRestExceptionHandler {
	
	SimpleDateFormat sdf = new SimpleDateFormat();
	
	@ExceptionHandler
	ResponseEntity<AlreadyExistingUserErrorResponse> existingUserException(AlreadyExistingUserException exc){
		
		AlreadyExistingUserErrorResponse error = new AlreadyExistingUserErrorResponse(
				HttpStatus.NOT_ACCEPTABLE.value(),
				exc.getMessage(),
				String.valueOf(sdf.format(System.currentTimeMillis()))
				);
		
		return new ResponseEntity<>(error,HttpStatus.NOT_ACCEPTABLE);
	}

}
