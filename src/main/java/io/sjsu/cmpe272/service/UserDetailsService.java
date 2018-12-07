package io.sjsu.cmpe272.service;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import io.sjsu.cmpe272.model.User;
import io.sjsu.cmpe272.repository.UserRepository;;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 User user = userRepository.findByUsername(username);
//		 Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//		 
//	     UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	     
	     return null;
	}
}
