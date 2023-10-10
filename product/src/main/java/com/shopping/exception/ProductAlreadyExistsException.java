package com.shopping.exception;


public class ProductAlreadyExistsException extends Exception{

	
private String msg;
	
	public ProductAlreadyExistsException() {
		super();
	}
	
	public ProductAlreadyExistsException(String msg) {
		super();
		this.msg=msg;
	}
}