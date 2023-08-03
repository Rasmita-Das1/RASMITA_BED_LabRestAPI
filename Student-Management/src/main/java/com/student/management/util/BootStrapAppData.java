package com.student.management.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.student.management.model.Role;
import com.student.management.model.User;
import com.student.management.repo.UserRepository;

import jakarta.transaction.Transactional;

@Configuration
public class BootStrapAppData {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@EventListener(ApplicationReadyEvent.class)
	@Transactional
	public void loadUsers(ApplicationReadyEvent event) {

		// Addding users and roles
		User kiran = new User("kiran", this.passwordEncoder.encode("welcome"));
		User vinay = new User("vinay", this.passwordEncoder.encode("welcome"));
		User ramesh=new User("ramesh", this.passwordEncoder.encode("welcome"));

		Role userRole = new Role("ROLE_USER");
		Role adminRole = new Role("ROLE_ADMIN");
		Role superAdminRole=new Role("ROLE_SUPER_ADMIN");

		kiran.addRole(userRole);

		vinay.addRole(userRole);
		vinay.addRole(adminRole);
		
		ramesh.addRole(userRole);
		ramesh.addRole(adminRole);
		ramesh.addRole(superAdminRole);

		this.userRepository.save(kiran);
		this.userRepository.save(vinay);
		this.userRepository.save(ramesh);

	}

}