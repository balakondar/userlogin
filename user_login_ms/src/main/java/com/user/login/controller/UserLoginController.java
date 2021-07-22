package com.user.login.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.login.entity.User;
import com.user.login.exception.UserNotFoundException;
import com.user.login.request.UserLoginRequest;
import com.user.login.service.UserLoginService;

@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserLoginController {
	
	private static final Logger log = LoggerFactory.getLogger(UserLoginController.class);
	
	@Autowired
	UserLoginService userLoginService;
	
	@PostMapping("/Login")	
	public User loginUser(@RequestBody UserLoginRequest userLoginRequest) throws UserNotFoundException {
		log.info("Login service in UserLoginController");
		return userLoginService.loginUser(userLoginRequest); 
	}
	
	@PostMapping("/CreateUser")
	public User createUser(@RequestBody User user) {
		log.info("CreateUser service in UserLoginController");
		return userLoginService.createUser(user);
	}
	
	@PutMapping("/UpdateUser")
	public User UpdateUser(@RequestBody User user) {
		log.info("UpdateUser service in UserLoginController");
		return userLoginService.updateUser(user);
	}
	
	@DeleteMapping("/DeleteUser/{userId}")
	public Integer deleteUser(@PathVariable Integer userId ) {
		log.info("DeleteUser service in UserLoginController");
		return userLoginService.deleteUser(userId);
	}
	
	@GetMapping("/FetchUser")
	public List<User> fetchUserWithRoles() {
		log.info("FetchUserWithRoles service in UserLoginController");
		return userLoginService.fetchUserWithRoles(); 
	}


}
