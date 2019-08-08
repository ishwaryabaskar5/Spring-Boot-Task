package com.stackroute.muzix.exception;

//custom exception
public class TrackAlreadyExistsException extends Exception {
	
	public TrackAlreadyExistsException() {
	}
	
	public TrackAlreadyExistsException(String message) {
		super(message);
	}
}
