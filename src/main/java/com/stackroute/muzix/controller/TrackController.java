package com.stackroute.muzix.controller;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
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
@RequestMapping("api/v1")
@Api(value = "Track CRUD Operation")
public class TrackController {

	private TrackService trackService;
	
	@Autowired
	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}
	
	@ApiOperation(value = "View a list of available track", response = List.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})
	
	
	@GetMapping(value = "/tracks")
	public ResponseEntity<?> getAllTracks(){
		ResponseEntity responseEntity;
		List<Track> tracks;
		try{
			tracks = trackService.getAllTracks();
			responseEntity = new ResponseEntity<List<Track>>(tracks, HttpStatus.OK);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exceptiom", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
	
	@ApiOperation(value = "Create a Track")
	@PostMapping(value = "/track")
	public ResponseEntity<?> saveTrack(@RequestBody Track track){
		ResponseEntity responseEntity;
		try{		
			responseEntity = new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.CREATED);

		} catch (TrackAlreadyExistsException e){
			responseEntity = new ResponseEntity<String>("id already exists", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@ApiOperation(value = "Update a Track")
	@PutMapping(value = "/track/{id}")
	public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
		ResponseEntity responseEntity;
		try{
			responseEntity = new ResponseEntity<Track>(trackService.updateTrack(id,track), HttpStatus.OK);
		} catch (TrackNotFoundException e){
			responseEntity = new ResponseEntity<String>("id not found", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@ApiOperation(value = "Delete a Track")
	@DeleteMapping(value = "/track/{id}")
	public ResponseEntity<?> deleteTrack(@PathVariable("id") int id){
		ResponseEntity responseEntity;
		try{
			responseEntity = new ResponseEntity<Track>(trackService.deleteTrack(id), HttpStatus.OK);

		} catch (TrackNotFoundException e){
			responseEntity = new ResponseEntity<String>("id not found", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	@ApiOperation(value = "Get a track by name")
	@GetMapping(value = "/track/{name}")
	public ResponseEntity<?> getTrack(@PathVariable("name") String name){
		ResponseEntity responseEntity;
		List<Track> tracks;
		try{
			tracks = trackService.findTrackByName(name);
			responseEntity = new ResponseEntity<List<Track>>(tracks, HttpStatus.OK);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
}
