package com.db.hackathon.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.db.hackathon.model.User;

public interface UserService extends UserDetailsService {

	User findByUserName(String email);

	User save(User user);
}