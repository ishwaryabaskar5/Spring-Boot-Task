package com.stackroute.muzix.controller;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class TrackController {

	private TrackService trackService;
	
	@Autowired
	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}
	
	//  maps the http get method url with corresponding service method
		@GetMapping(value = "/tracks")
	public ResponseEntity<?> getAllTracks(){
		ResponseEntity responseEntity;
		List<Track> tracks;
		try{
//			calls getAllTracks() from service
			tracks = trackService.getAllTracks();
			responseEntity = new ResponseEntity<List<Track>>(tracks, HttpStatus.OK);
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
		}
//		returns response entity
		return responseEntity;
	}
	
//	maps the http post method url with corresponding service method
	@ApiOperation(value = "Create a Track")
	@PostMapping(value = "/track")
	public ResponseEntity<?> saveTrack(@RequestBody Track track){
		ResponseEntity responseEntity;
		try{
//			calls saveTrack() from service
			responseEntity = new ResponseEntity<Track>(trackService.saveTrack(track), HttpStatus.CREATED);
		} catch (TrackAlreadyExistsException e){
			responseEntity = globalExceptionHandler.handleTrackAlreadyExistsException();
		}
		return responseEntity;
	}
//	maps the http put method url with corresponding service method
	
	@ApiOperation(value = "Update a Track")
	@PutMapping(value = "/track/{id}")
	public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody Track track){
		ResponseEntity responseEntity;
		try{
//			calls updateTrack() from service
			responseEntity = new ResponseEntity<Track>(trackService.updateTrack(id,track), HttpStatus.OK);
		} catch (TrackNotFoundException e){
			responseEntity = globalExceptionHandler.handleTrackNotFoundException();
		}
		return responseEntity;
	}
	
//	maps the http delete method url with corresponding service method
	@ApiOperation(value = "Delete a Track")
	@DeleteMapping(value = "/track/{id}")

	public ResponseEntity<?> deleteTrack(@PathVariable("id") int id){
		ResponseEntity responseEntity;
		try{
//			calls deleteTrack() from service
			responseEntity = new ResponseEntity<Track>(trackService.deleteTrack(id), HttpStatus.OK);
		} catch (TrackNotFoundException e){
			responseEntity = globalExceptionHandler.handleTrackNotFoundException();
		}
		return responseEntity;
	}
	
	//  maps the http get method url with corresponding service method
	@GetMapping(value = "/toptracks")
	public ResponseEntity<?> getTopTracks(){
		ResponseEntity responseEntity;
		List<Track> tracks;
		try{
			trackService.getTopTracks();
			responseEntity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e){
			System.out.println("Exception started");
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
}
