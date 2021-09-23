package com.task.reactAuth.rest;

public class IsAuthenticated {
	
	private String email;
	
	private String password;
	
	public IsAuthenticated() {
		
	}

	public IsAuthenticated(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "IsAuthenticated [email=" + email + ", password=" + password + "]";
	}
	
	
	

}
