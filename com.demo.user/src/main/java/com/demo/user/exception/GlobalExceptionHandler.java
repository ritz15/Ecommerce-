package com.demo.user.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = UserAlreadyExistsException.class)
	    public ResponseEntity<String> userAlreadyExists(UserAlreadyExistsException user){
	    	return new ResponseEntity<String>("User already exist,Please try again",HttpStatus.CONFLICT);
	    	
}
  @ExceptionHandler(value=UserDoesntExistException.class)
	public ResponseEntity<String> userDoesntExists(UserDoesntExistException user){
		return new ResponseEntity<String>(" This user doesnt exist,please enter correcr details",HttpStatus.BAD_REQUEST);
	}
  
	   @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String,String>> handleMethosArgsNotValidException(MethodArgumentNotValidException ex){
	    	
	    	Map<String,String> rsp=new HashMap<>();
	    	 ex.getBindingResult().getAllErrors().forEach((error)->{
	    	String fieldName=((FieldError)error).getField();
	    
	    	String message=error.getDefaultMessage();
	    	rsp.put(fieldName, message);
	    	 });
	    		
	    	 
	    	return new ResponseEntity<Map<String,String>>(rsp,HttpStatus.BAD_REQUEST);
	    	
	    } 
	    
}
