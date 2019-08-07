package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;

import java.util.List;

//service interfaces
public interface TrackService {
	
	 boolean saveTrack(Track track);
	
 boolean deleteTrack(int id);
	
	 List<Track> getAllTracks();
	
	 boolean updateTrack(int id, Track track);
	
	 List<Track> findTrackByName(String name);
}
