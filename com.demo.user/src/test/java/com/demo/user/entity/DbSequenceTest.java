package com.demo.user.entity;

import org.junit.jupiter.api.AfterEach;

import com.demo.user.entity.User;

public class DbSequenceTest {

	
	User user;
	@AfterEach
	public void after() {
		user =null;
	}
}
