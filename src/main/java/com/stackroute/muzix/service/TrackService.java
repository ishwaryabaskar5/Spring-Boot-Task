package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;

import java.util.List;

public interface TrackService {
	
	 Track saveTrack(Track track) throws TrackAlreadyExistsException;
	
	Track deleteTrack(int id) throws TrackNotFoundException;
	
	 List<Track> getAllTracks() throws InterruptedException;
	
	Track updateTrack(int id, Track track) throws TrackNotFoundException;
	
}
