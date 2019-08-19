package com.stackroute.muzix.controller;

import com.stackroute.muzix.dto.TrackDto;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.TrackService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1")
@CrossOrigin
//  class level request mapping
public class TrackController {
	
	private TrackService trackService;
	@Autowired
	ModelMapper modelMapper;    //auto wiring modelMapper
	
	private final Logger logger = LoggerFactory.getLogger(TrackController.class.getName());
	
	@Autowired              // constructor based autowiring
	public TrackController(TrackService trackService) {
		this.trackService = trackService;
	}
	
	//  maps the http get method url with corresponding service method
	@GetMapping(value = "/tracks")
	public ResponseEntity<?> getAllTracks(){
		ResponseEntity responseEntity;
		List<Track> tracks;
		List<TrackDto> tracksDto;
	
		try{
//			calls getAllTracks() from service
			tracks = trackService.getAllTracks();
//			converting list of track obj into list of trackDto object
			tracksDto = tracks.stream().map(track -> modelMapper.map(track,TrackDto.class)).collect(Collectors.toList());
			responseEntity = new ResponseEntity<List<TrackDto>>(tracksDto, HttpStatus.OK);
			logger.info("get all tracks api call success");
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.BAD_REQUEST);
			logger.error("get all tracks api call throws an exception");
		}
//		returns response entity
		return responseEntity;
	}
	
	//	maps the http post method url with corresponding service method
	@PostMapping(value = "/track")
	public ResponseEntity<?> saveTrack(@RequestBody TrackDto trackDto){
		ResponseEntity responseEntity;
		try{
//			converting incoming trackDto object into track object
			responseEntity = new ResponseEntity<Track>(trackService.saveTrack(modelMapper.map(trackDto,Track.class)), HttpStatus.CREATED);
			logger.info("save track api call success");
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
			logger.error("save track api call throws an exception");
			
		}
		return responseEntity;
	}
	
	//	maps the http put method url with corresponding service method
	@PutMapping(value = "/track/{id}")
	public ResponseEntity<?> updateTrack(@PathVariable int id,@RequestBody TrackDto trackDto){
		ResponseEntity responseEntity;
		try{
//			converting incoming trackDto object into track object
			responseEntity = new ResponseEntity<Track>(trackService.updateTrack(id,modelMapper.map(trackDto,Track.class)), HttpStatus.OK);
			logger.info("update track api call success");
		} catch (Exception e){
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
			logger.error("update track api call throws an exception");
		}
		return responseEntity;
	}
	
	//	maps the http delete method url with corresponding service method
	@DeleteMapping(value = "/track/{id}")
	public ResponseEntity<?> deleteTrack(@PathVariable("id") int id){
		ResponseEntity responseEntity;
		try{
//			calls deleteTrack() from service
			responseEntity = new ResponseEntity<Track>(trackService.deleteTrack(id), HttpStatus.OK);
			logger.info("delete track api call success");
		} catch (Exception e){
			e.printStackTrace();
			responseEntity = new ResponseEntity<String>("Exception", HttpStatus.CONFLICT);
			logger.error("delete track api call throws an exception");
		}
		return responseEntity;
	}
}
