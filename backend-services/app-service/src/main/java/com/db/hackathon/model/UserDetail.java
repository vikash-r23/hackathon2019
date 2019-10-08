package com.db.hackathon.model;

public class UserDetail {
	
	private String userId;
	private User user;
	
	public UserDetail(String userId, User user) {
		super();
		this.userId = userId;
		this.user = user;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
