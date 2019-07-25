package com.stackroute.muzix.controller;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TrackAlreadyExistsException.class)
	public ResponseEntity handleTrackAlreadyExistsException(){
		return new ResponseEntity<String>("id already exists",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TrackNotFoundException.class)
	public ResponseEntity handleTrackNotFoundException(){
		return new ResponseEntity<String>("track not found",HttpStatus.NOT_FOUND);
	}
}
