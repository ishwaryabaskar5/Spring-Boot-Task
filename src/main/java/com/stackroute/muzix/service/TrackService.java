package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;

import java.util.List;

public interface TrackService {
	
	public boolean saveTrack(Track track) throws TrackAlreadyExistsException;
	
	public boolean deleteTrack(int id) throws TrackNotFoundException;
	
	public List<Track> getAllTracks();
	
	public boolean updateTrack(int id, Track track) throws TrackNotFoundException;
	
	public List<Track> findTrackByName(String name);
}
