package com.db.hackathon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.db.hackathon.constants.UserStatus;
import com.db.hackathon.model.User;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		if(UserStatus.N.equals(user.getEnabled())) {
			throw new DisabledException("User is not active: " + username);
		}
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(user.getUserType().toString()));
		list.add(new SimpleGrantedAuthority(String.valueOf(user.getUserId())));
		list.add(new SimpleGrantedAuthority(String.valueOf(user.getFirstName())));
		list.add(new SimpleGrantedAuthority(String.valueOf(user.getLastName())));
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),list);
	}
}