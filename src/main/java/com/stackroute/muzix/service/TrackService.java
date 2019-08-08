package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;

import java.util.List;

//Service interface
public interface TrackService {
	
	 Track saveTrack(Track track);
	
	Track deleteTrack(int id);
	
	 List<Track> getAllTracks();
	
	 Track updateTrack(int id, Track track);
	
}
