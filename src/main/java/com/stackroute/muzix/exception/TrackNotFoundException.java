package com.stackroute.muzix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//custom exception TrackNotFoundException
public class TrackNotFoundException extends Exception {
	
	public TrackNotFoundException() {
	}
	
	public TrackNotFoundException(String message) {
		super(message);
	}
}
