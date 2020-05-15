package com.db.hackathon.model;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class JwtRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;

	@NotBlank(message = "Please provide a username")
	@Email(message = "User name must be an email")
	private String username;
	@NotBlank
	private String password;

	// Need default constructor for JSON Parsing
	public JwtRequest() {

	}

	public JwtRequest(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}