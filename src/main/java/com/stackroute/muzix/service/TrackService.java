package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;

import java.util.List;

public interface TrackService {
	
	public boolean saveTrack(Track track);
	
	public boolean deleteTrack(int id);
	
	public List<Track> getAllTracks();
	
	public boolean updateTrack(int id, Track track);
	
	public void getTopTracks();
}
