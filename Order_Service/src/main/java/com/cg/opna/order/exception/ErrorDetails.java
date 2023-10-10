package com.cg.opna.order.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    
	private String ErrorMessage;
	private LocalDateTime TimeStamp;
	public ErrorDetails(String errorMessage, LocalDateTime timeStamp) {
		super();
		ErrorMessage = errorMessage;
		TimeStamp = timeStamp;
	}
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
	public LocalDateTime getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		TimeStamp = timeStamp;
	}
	
	
}
