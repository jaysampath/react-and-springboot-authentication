package com.task.reactAuth.rest;

public class ResponseMessage {
	
	private int status;
	
	private String message;
	
	private String time;
	
	public ResponseMessage() {
		
	}

	public ResponseMessage(int status, String message, String time) {
		this.status = status;
		this.message = message;
		this.time = time;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "SuccessMessage [status=" + status + ", message=" + message + ", time=" + time + "]";
	}

	
	
	

}
