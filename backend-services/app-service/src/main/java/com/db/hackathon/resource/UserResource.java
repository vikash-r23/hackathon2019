package com.db.hackathon.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.hackathon.exception.CustomValidationException;
import com.db.hackathon.model.JwtRequest;
import com.db.hackathon.model.JwtResponse;
import com.db.hackathon.model.User;
import com.db.hackathon.security.JwtTokenUtil;
import com.db.hackathon.service.JwtUserDetailsService;
import com.db.hackathon.service.UserService;
import com.db.hackathon.validator.UserValidator;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserResource {

	@Autowired
	private UserService userServcie;

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user, BindingResult bindingResult) {
		userValidator.validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			throw new CustomValidationException(bindingResult);
		}
		return new ResponseEntity<User>(userServcie.save(user), HttpStatus.CREATED);
	}

	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequest authenticationRequest) throws Exception {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException  e) {
			throw new AuthenticationCredentialsNotFoundException("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new AuthenticationCredentialsNotFoundException("INVALID_CREDENTIALS", e);
		}
	}

}
