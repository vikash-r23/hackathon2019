package com.db.hackathon.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String userId;
	private String userName;
	private String userType;
	private final String jwttoken;
	private String loginTime;
	
	public JwtResponse(String userId,String userName, String userType, String jwttoken) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
		this.jwttoken = jwttoken;
		this.loginTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").format(LocalDateTime.now());
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getJwttoken() {
		return jwttoken;
	}


}