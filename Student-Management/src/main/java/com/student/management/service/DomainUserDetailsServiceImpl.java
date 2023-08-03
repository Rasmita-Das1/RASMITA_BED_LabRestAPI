package com.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.student.management.model.DomainUserDetails;
import com.student.management.repo.UserRepository;

@Service
public class DomainUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = this.userRepository
							.findByUsername(username)
							.map(DomainUserDetails::new)
							.orElseThrow(() -> new UsernameNotFoundException("invalid username"));
		
		System.out.println("User:" + user.getUsername());
		System.out.println("Roles:" + user.getAuthorities());
		return user;
	}

}
