package com.demo.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.user.entity.User;
import com.demo.user.exception.UserAlreadyExistsException;
import com.demo.user.exception.UserDoesntExistException;
//import com.demo.user.exception.UserAlreadyExistsException;
//import com.demo.user.exception.UserDoesntExistException;
import com.demo.user.repository.UserRepository;
import com.demo.user.service.UserService;
import com.demo.user.service.UserServiceImpl;

//@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class ServiceMackitoTests {
	@Autowired
	private UserService userService;
	@MockBean
	UserRepository userRepository;
	@InjectMocks
	private UserServiceImpl userServiceImpl;

	public List<User> myusers;

	 @Test
		void test_UserServiceNotNull() {
			assertThat(userServiceImpl).isNotNull();
		}
		
		@Test
		void test_UserRepositoryNotNull() {
			assertThat(userRepository).isNotNull();
		}
		
	
	@Test
	public void test_getAllUsers() {

		when(userRepository.findAll())
		.thenReturn(Stream.of(new User(1, "ritika", null, 0, null, null, null, null)).collect(Collectors.toList()));
		assertEquals(1, userService.getAllUsers().size());

	}

	@Test
	public void test_saveUser() throws UserAlreadyExistsException {
		User user = new User(1, "ritika", null, 0, null, null, null, null);
		userService.saveUser(user);
		verify(userRepository, times(1)).save(user);

	}

	@Test
	public void test_deleteUser() {
		User user = new User(1, "ritika", null, 0, null, null, null, null);
		userRepository.delete(user);
		verify(userRepository, times(1)).delete(user);
	}

	@Test
	public void test_update() {
		User user = new User(1, "ritika", null, 0, null, null, null, null);
		userService.update(user);
		verify(userRepository, times(1)).save(user);
	}

	
	//error aa rha
	 @Test public void test_getUserById() throws UserDoesntExistException {
	  List<User> myusers=new ArrayList<User>();
	  myusers.add(new User(1,"ritika", null, 0, null, null, null, null)); 
	  myusers.add(new User(2,"ritika", null, 0, null,null, null, null)); 
	  int userID=1;
	  when(userRepository.findAll()).thenReturn(myusers); 
	  assertEquals(1, userService.getUserById(userID).get());
	  
	  }
	 
	
	
	 

}
