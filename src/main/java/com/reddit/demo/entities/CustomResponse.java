package com.reddit.demo.entities;

public class CustomResponse {
	private String message;
	private Boolean error;
	
	
	public CustomResponse(String message, Boolean error) {
		super();
		this.message = message;
		this.error = error;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getError() {
		return error;
	}
	public void setError(Boolean error) {
		this.error = error;
	}
	
	
}
