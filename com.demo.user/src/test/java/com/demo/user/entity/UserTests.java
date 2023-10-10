package com.demo.user.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserTests {

	User user;
	
	 @BeforeEach
		public void before() {
		 user = new User(1,"ritika", "female", 10,  "abc15@gmail.com","GreenCity", "User", "pass");
		} 
	
		
		
		@AfterEach
		public void after() {
			user=null;
		}
		
		@Test
		void test_GetId() {
			assertEquals(1, user.getId());
		}
	

		@Test
		void test_GetName() {
			assertEquals("ritika", user.getName());
		}

		@Test
		void test_GetGender() {
			assertEquals("female", user.getGender());
		}

		@Test
		void test_GetAge() {
			assertEquals(10, user.getAge());
		}
		@Test
		void test_GetEmail() {
			assertEquals("abc15@gmail.com",user.getEmail());
		}
		@Test
		void test_GetAddress() {
			assertEquals("GreenCity",user.getAddress());
		}
		@Test
		void test_GetRole() {
			assertEquals("User",user.getRole());
		}
		@Test
		void test_GetPassword() {
			assertEquals("pass",user.getPassword());
		}
		@Test
		void test_SetId() {
			user.setId(1);
			assertEquals(1, user.getId());
		}

		@Test
		void test_SetName() {
			user.setName("ritika");
			assertEquals("ritika", user.getName());
		}

		@Test
		void test_SetGender() {
			user.setGender("female");
			assertEquals("female", user.getGender());
		}

		@Test
		void test_SetAge() {
			user.setAge(10);
			assertEquals(10, user.getAge());
		}
		@Test
		void test_SetEmail() {
			user.setEmail("abc15@gmail.com");
			assertEquals("abc15@gmail.com",user.getEmail());
		}
		
		@Test
		void test_SetAddress() {
			user.setAddress("GreenCity");
			assertEquals("GreenCity",user.getAddress());
		}
		@Test
		void test_SetRole() {
			user.setRole("User");
			assertEquals("User",user.getRole());
		}
		@Test
		void test_SetPassword() {
			user.setPassword("pass");
			assertEquals("pass",user.getPassword());
		}
		
}
