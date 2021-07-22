package com.user.login.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.login.entity.User;
import com.user.login.exception.UserNotFoundException;
import com.user.login.repository.UserRepository;
import com.user.login.request.UserLoginRequest;
import com.user.login.service.UserLoginService;

@Service
public class UserLoginServiceImpl implements UserLoginService {

	private static final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		log.info("Before createUser");
		User cUser = userRepository.save(user);
		log.info("User Created Sucessfully :" + cUser.getUserId());

		return cUser;
	}

	@Override
	public User updateUser(User user) {
		log.info("Before updateUser");
		try {
			if (userRepository.findById(user.getUserId()).isPresent()) {
				User dbUser = userRepository.findById(user.getUserId()).get();
				dbUser.setFirstName(user.getFirstName());
				dbUser.setLastName(user.getLastName());
				dbUser.setEmail(user.getEmail());
				if(user.getPassword()!=null) {
					dbUser.setPassword(user.getPassword());
				}
				if(user.getRoles()!=null) {				
					dbUser.setRoles(user.getRoles());
				}
				userRepository.save(user);
				log.info("User Updated Sucessfully :" + dbUser.getUserId());
			}
		} catch (Exception e) {
			log.error("Exception while upadting User :" + e);
		}
		return user;

	}

	@Override
	public Integer deleteUser(Integer UserId) {
		log.info("Before deleteUser");
		userRepository.deleteById(UserId);
		log.info("User Deleted Sucessfully :" + UserId);
		return UserId;

	}

	@Override
	public List<User> fetchUserWithRoles() {
		log.info("Before fetchUserWithRoles");
		List<User> usrsList = userRepository.findAll();
		log.info("Fetch User List :" + usrsList);

		return usrsList;
	}
	
	@Override
	public User loginUser(UserLoginRequest userLoginRequest) {
		log.info("Before loginUser");
		User user=userRepository.loginUser(userLoginRequest.getEmail(),userLoginRequest.getPassword());
		if(user!=null && user.getUserId().intValue()>0) {
			log.info(" User login Sucessfully :" + user.getUserId());
		}else {
			throw new UserNotFoundException("Login User Not Found");
		}
		return user;

	}

}
