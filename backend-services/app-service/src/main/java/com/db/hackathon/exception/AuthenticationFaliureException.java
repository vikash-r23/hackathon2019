package com.db.hackathon.exception;

public class AuthenticationFaliureException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Exception ex;
	private String message;
	
	public AuthenticationFaliureException(Exception ex, String message) {
		super();
		this.ex = ex;
		this.message = message;
	}

	public Exception getEx() {
		return ex;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
