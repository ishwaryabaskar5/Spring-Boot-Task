package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;

import java.util.List;

//Service interface
public interface TrackService {
	
	public Track saveTrack(Track track);
	
	public Track deleteTrack(int id);
	
	public List<Track> getAllTracks();
	
	public Track updateTrack(int id, Track track);
	
}
