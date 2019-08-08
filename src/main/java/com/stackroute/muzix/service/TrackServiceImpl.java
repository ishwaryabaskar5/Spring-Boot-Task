package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
	
	TrackRepository trackRepository;
	
	@Autowired  //constructor based auto wiring
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
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
			trackRepository.deleteById(id);
			track= trackRepository.findById(id);
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
	
// 	method for get all the tracks from DB
	@Override
	public List<Track> getAllTracks() {
		List<Track> trackList = trackRepository.findAll();
		return trackList;
	}

// 	method for find tracks by teack id from DB
	@Override
	public List<Track> findTrackByName(String name){
		return trackRepository.trackByName(name);
	}
}
