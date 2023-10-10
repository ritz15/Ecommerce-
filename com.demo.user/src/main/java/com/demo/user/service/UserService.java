package com.demo.user.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.demo.user.entity.User;
import com.demo.user.exception.UserAlreadyExistsException;
import com.demo.user.exception.UserDoesntExistException;

public interface UserService {

	User saveUser(User user) throws UserAlreadyExistsException;

	List<User> getAllUsers();

	Optional<User> getUserById(int id) throws UserDoesntExistException;

	void update(User user);

	

	void deleteById(int id) throws UserDoesntExistException;

	String update( int id, User user) throws UserAlreadyExistsException;

	

	

}
