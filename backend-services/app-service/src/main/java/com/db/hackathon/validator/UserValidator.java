package com.db.hackathon.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.db.hackathon.constants.AppConstants;
import com.db.hackathon.model.User;
import com.db.hackathon.service.UserService;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		if (user.getPassword().length() < 8 ) {
			errors.rejectValue("password", "length", "Password must be at least 6 charaters long");
		}
		if (!user.getPassword().matches(AppConstants.PASSWORD_MATCHER_REGEX)) {
			errors.rejectValue("password", "pattern", "Password must conatin at least an Uppercase letter , a Lowercase letter , a number and a Special character");
		}
		if (!user.getPassword().equals(user.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "match", "Passwords do not match");
		}
		User existingUser = userService.findByUserName(user.getUserName());
		if ( null != existingUser && existingUser.getUserName().equals(user.getUserName())) {
			errors.rejectValue("userName", "present", "Username already exists");
		}
	}

}
