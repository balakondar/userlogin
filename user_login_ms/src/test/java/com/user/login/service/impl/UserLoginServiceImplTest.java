package com.user.login.service.impl;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.user.login.entity.Role;
import com.user.login.entity.User;
import com.user.login.repository.UserRepository;
import com.user.login.service.UserLoginService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserLoginServiceImplTest {
	
	@Autowired
	private UserLoginService userLoginService;	
	
	@MockBean
	private UserRepository userRepository;
	
	
	@Test
	public void createUserTest() {
		
		User user=getUser();
		user.setUserId(null);		
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userLoginService.createUser(user));

	}
	
	@Test
	public void updateUserTest() {
		
		User user=getUser();
		when(userRepository.save(user)).thenReturn(user);
		assertEquals(user,userLoginService.updateUser(user));

	}
	
	@Test
	public void fetchUserWithRolesTest() {		
		when(userRepository.findAll()).thenReturn(Stream.of(getUser()).collect(Collectors.toList()));
		assertEquals(1,userLoginService.fetchUserWithRoles().size());
	}
	
	private User getUser() {
		User user=new User();
		user.setUserId(2);
		user.setFirstName("Bala");
		user.setLastName("Konda");
		user.setEmail("balakondar@gmail.com");
		user.setEnabled("Y");
		
		Set<Role> roles = new HashSet<>();
		Role role=new Role();
		role.setRoleName("User");
		roles.add(role);
		user.setRoles(roles);
		
		return user;
		
	}
	
	@Test
	public void DeleteUserTest() {
		Integer usrId=4;
		userLoginService.deleteUser(usrId);
		verify(userRepository,times(1)).deleteById(usrId);

	}
	
}
