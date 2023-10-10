package com.demo.user.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;


import com.demo.user.controller.UserController;
import com.demo.user.entity.User;
import com.demo.user.exception.UserAlreadyExistsException;
import com.demo.user.exception.UserDoesntExistException;
import com.demo.user.service.UserService;
import com.demo.user.service.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

//@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerMackitoTests {
	@Mock
	UserService userServ;
	@InjectMocks
	UserController userController;
	@MockBean
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	MockMvc mockMvc;

	List<User> myusers;
	User user;

	
	@Test
	void test_UserServiceNotNull() {
		assertThat(userServiceImpl).isNotNull();
	}
	
	@Test
	void testMockMvcNotNull() {
		assertThat(mockMvc).isNotNull();
	}
	
	
	@Test
	@Order(1)
	public void test_getAllUsers() {
		myusers = new ArrayList<User>();
		myusers.add(new User(1, "ssz", "seg", 0, null, null, null, null));
		myusers.add(new User(2, "ssz", "seg", 0, null, null, null,null));

		when(userServ.getAllUsers()).thenReturn(myusers);// mocking
		ResponseEntity<List<User>> res = userController.getAllUsers();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2,res.getBody().size());
	}
	
	 @Test
	void test_getUserById() throws Exception {
		Optional<User> user=Optional.of(new User(101,"MI-pro7","mobile",20000, null, null, null, null));
	when(userServiceImpl.getUserById(101)).thenReturn(user);
	mockMvc.perform(get("/user/101"))
	//.andExpect(status().isOk())
	.andExpect(content().contentType("application/json"))
	.andExpect(jsonPath("$.id").value(101))
	.andExpect(jsonPath("$.name").value("MI-pro7"))
	.andExpect(jsonPath("$.gender").value("mobile"))
	.andExpect(jsonPath("$.age").value(20000));
		
	}
	 @Test
		void test_saveUser() throws Exception {
			User u1=new User(101,"Mumbai","Mirza",900009000, "mirza@gmail.com", "Mirza@1", "mirza", null);
			User u2=new User(102,"Kolkata","Kina",900709000, "kina@gmail.com", "Kina@1", "kina", null);
			List<User> userList=new ArrayList<User>();
			userList.add(u1);
			userList.add(u2);
			when(userServ.getAllUsers()).thenReturn(userList);
		mockMvc.perform(get("/user"));
			 
		}
	
		
}

