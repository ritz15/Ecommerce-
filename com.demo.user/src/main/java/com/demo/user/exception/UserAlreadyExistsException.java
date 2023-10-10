package com.demo.user.exception;

public class UserAlreadyExistsException extends Exception{

	
private String msg;
	
	public UserAlreadyExistsException() {
		super();
	}
	
	public UserAlreadyExistsException(String msg) {
		super();
		this.msg=msg;
	}
}
