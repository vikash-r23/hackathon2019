package com.db.hackathon.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.exception.CustomValidationException;
import com.db.hackathon.model.User;
import com.db.hackathon.service.UserService;
import com.db.hackathon.validator.UserValidator;

@RestController
@RequestMapping("/api/user")
public class UserResource {
	
	@Autowired
	private UserService userServcie;
	
	@Autowired
	private UserValidator userValidator;
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user , BindingResult bindingResult){
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			throw new CustomValidationException(bindingResult);
		}
		return new ResponseEntity<User>(userServcie.save(user), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<User> login(@Valid @RequestBody User user , BindingResult bindingResult){
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			throw new CustomValidationException(bindingResult);
		}
		return new ResponseEntity<User>(userServcie.save(user), HttpStatus.CREATED);
	}

}
