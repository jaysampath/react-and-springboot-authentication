package com.task.reactAuth.rest;

public class AlreadyExistingUserException extends RuntimeException {
      
	public AlreadyExistingUserException(String message) {
		super(message);
	}
}
