package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;

import java.util.List;

//Service interface
public interface TrackService {
	
	 boolean saveTrack(Track track) throws TrackAlreadyExistsException;
	
	 boolean deleteTrack(int id) throws TrackNotFoundException;
	
	 List<Track> getAllTracks();
	
	 boolean updateTrack(int id, Track track) throws TrackNotFoundException;
	
	 List<Track> findTrackByName(String name);
}
