package com.stackroute.muzix.controller;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")       //  class level request mapping
@Api(value = "Track CRUD Operation")
public class TrackController {
	
	private TrackService trackService;
	
	@Autowired
	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}
	
	//  maps the http get method url with corresponding service method
//	addi swagger documentation for the method with possible responses
	@ApiOperation(value = "View a list of available track", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	@GetMapping(value = "/tracks")
	public ResponseEntity<?> getAllNotes(){
		ResponseEntity responseEntity;
		List<Track> tracks;
		try{
			tracks = trackService.getAllTracks();
			responseEntity = new ResponseEntity<List<Track>>(tracks, HttpStatus.OK);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	//	maps the http post method url with corresponding service method
	@ApiOperation(value = "Create a Track")
	@PostMapping(value = "/track")
	public ResponseEntity<?> saveNote(@RequestBody Track track){
		ResponseEntity responseEntity;
		try{
			trackService.saveTrack(track);
			responseEntity = new ResponseEntity<String>("Successfully Created", HttpStatus.CREATED);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	
	//	maps the http put method url with corresponding service method
	@ApiOperation(value = "Update a Track")
	@PutMapping(value = "/track/{id}")
	public ResponseEntity<?> updateNote(@PathVariable int id,@RequestBody Track track){
		ResponseEntity responseEntity;
		try{
			trackService.updateTrack(id,track);
			responseEntity = new ResponseEntity<String>("Successfully Updated", HttpStatus.OK);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	//	maps the http delete method url with corresponding service method
	@ApiOperation(value = "Delete a Track")
	@DeleteMapping(value = "/track/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable("id") int id){
		ResponseEntity responseEntity;
		try{
			trackService.deleteTrack(id);
			responseEntity = new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
}