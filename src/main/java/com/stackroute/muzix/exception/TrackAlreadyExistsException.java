package com.stackroute.muzix.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//custom exception TrackAlreadyExistsException
public class TrackAlreadyExistsException extends Exception {
	
	public TrackAlreadyExistsException() {
	}
	
	public TrackAlreadyExistsException(String message) {
		super(message);
	}
}
