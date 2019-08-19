package com.stackroute.muzix.service;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
	
	TrackRepository trackRepository;
	
	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}
	
	//	method for getting all the tracks from database
	@Override
	@Cacheable("trackList")     //enables cache for this method
	public List<Track> getAllTracks() throws InterruptedException {
		List<Track> trackList = trackRepository.findAll();
		Thread.sleep(1000*5);
		return trackList;
	}
	
	// 	method for creating a new track in DB
	@Override
	public Track saveTrack(Track track) {
		return trackRepository.save(track);
	}
	
	// 	method for delete a track from DB using id
	@Override
	public Track deleteTrack(int id) {
		Optional<Track> track =null;
		if(trackRepository.existsById(id) == true) {
			track= trackRepository.findById(id);
			trackRepository.deleteById(id);
		}
		return track.get();
	}
	
	// 	method for update an existing track in DB
	@Override
	public Track updateTrack(int id, Track track) {
		if(trackRepository.existsById(id) == true){
			return trackRepository.save(track);
		}
		else
			return null;
	}
}