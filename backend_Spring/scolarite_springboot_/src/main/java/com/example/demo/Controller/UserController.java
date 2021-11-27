package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repos.UserRepository;

@RestController

public class UserController {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/register")
	public User Register(@RequestBody User user) {
		return userRepository.save(user);
	}

	@PostMapping("/login")
	public User Login(@RequestBody User user) {
		User oldUSer = userRepository.findByEmailAndPassword(user.email, user.password);
		return oldUSer;
	}
}