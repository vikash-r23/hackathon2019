package com.db.hackathon.exception;

import org.springframework.validation.BindingResult;

public class CustomValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private final BindingResult bindingResult;
	
	public CustomValidationException(BindingResult bindingResult) {
		this.bindingResult = bindingResult;
	}

	public BindingResult getBindingResult() {
		return bindingResult;
	}

}
