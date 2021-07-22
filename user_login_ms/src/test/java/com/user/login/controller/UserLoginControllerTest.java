package com.user.login.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.user.login.entity.Role;
import com.user.login.entity.User;
import com.user.login.request.UserLoginRequest;
import com.user.login.service.UserLoginService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = UserLoginController.class)
public class UserLoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	UserLoginService userLoginService;

	@SpyBean
	UserLoginController userLoginController;

	@Test
	public void createUserTest() throws Exception {
		User user = getUser();
		user.setUserId(null);
		String reqquest = mapToJson(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/User/CreateUser")
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(reqquest);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void updateUserTest() throws Exception {
		User user = getUser();
		String request = mapToJson(user);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/User/UpdateUser").accept(MediaType.APPLICATION_JSON).content(request)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
	
	@Test
	public void loginUserTest() throws Exception {
		UserLoginRequest userLoginRequest = new UserLoginRequest();
		String request = mapToJson(userLoginRequest);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/User/Login").accept(MediaType.APPLICATION_JSON).content(request)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
	
	@Test
	public void deleteUserTest() throws Exception {
		//Integer userId=2;
		//RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/DeleteUser/{userId}").accept(MediaType.APPLICATION_JSON)
				//.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform( MockMvcRequestBuilders.delete("/User/DeleteUser/2")).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	private String mapToJson(Object object) throws JsonProcessingException {		
		Gson gson = new Gson();
		return gson.toJson(object);

	}

	private User getUser() {
		User user = new User();
		user.setUserId(2);
		user.setFirstName("Bala");
		user.setLastName("Konda");
		user.setEmail("balakondar@gmail.com");
		user.setEnabled("Y");

		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleName("User");
		roles.add(role);
		user.setRoles(roles);

		return user;

	}

}
