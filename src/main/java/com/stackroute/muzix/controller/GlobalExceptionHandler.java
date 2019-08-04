package com.stackroute.muzix.controller;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Global exception handler using ControllerAdvice annotation
@ControllerAdvice
public class GlobalExceptionHandler {

//	hard coded values are removed using value annotation
	@Value("${trackAlreadyExistsExceptionMeassage}")
	private String trackAlreadyExistsExceptionMeassage;
	@Value("${trackNotFoundExceptionMeassage}")
	private String trackNotFoundExceptionMeassage;
	@Value("${exceptionMessage}")
	private String exceptionMessage;
	
//	ExceptionHandler for TrackAlreadyExistsException
	@ExceptionHandler(TrackAlreadyExistsException.class)
	public ResponseEntity handleTrackAlreadyExistsException(){
		return new ResponseEntity<String>(trackAlreadyExistsExceptionMeassage,HttpStatus.CONFLICT);
	}
	
//	ExceptionHandler for TrackNotFoundException
	@ExceptionHandler(TrackNotFoundException.class)
	public ResponseEntity handleTrackNotFoundException(){
		return new ResponseEntity<String>(trackNotFoundExceptionMeassage,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(){
		return new ResponseEntity<String>(exceptionMessage,HttpStatus.CONFLICT);
	}
}
