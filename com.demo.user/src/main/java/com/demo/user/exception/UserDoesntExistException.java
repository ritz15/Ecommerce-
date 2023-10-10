package com.demo.user.exception;

public class UserDoesntExistException extends Exception {
	
private String msg;
	
	public UserDoesntExistException() {
		super();
	}
	public UserDoesntExistException(String msg) {
		super();
		this.msg=msg;
	}
}
