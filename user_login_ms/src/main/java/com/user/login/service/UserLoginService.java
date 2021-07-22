package com.user.login.service;

import java.util.List;


import com.user.login.entity.User;
import com.user.login.request.UserLoginRequest;


public interface UserLoginService {
	
	
	 public User createUser(User user);
	 
	 public User updateUser(User user);
	 
	 public Integer deleteUser(Integer UserId);
	 
	 public List<User> fetchUserWithRoles();
	 
	 public User loginUser(UserLoginRequest userLoginRequest);
	 
}
