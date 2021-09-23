package com.task.reactAuth.rest;

public class AlreadyExistingUserErrorResponse {
	
	private int status;
	
	private String message;
	
	private String date;
	
	public AlreadyExistingUserErrorResponse() {
		
	}

	public AlreadyExistingUserErrorResponse(int status, String message, String date) {
		this.status = status;
		this.message = message;
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AlreadyExistingUserErrorResponse [status=" + status + ", message=" + message + ", date=" + date + "]";
	}
	
	
	

}
