package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {
	
	TrackRepository trackRepository;
	
	@Autowired
	public TrackServiceImpl(TrackRepository trackRepository) {
		this.trackRepository = trackRepository;
	}
	
	@Override
	public boolean saveTrack(Track track) throws TrackAlreadyExistsException {
		if (trackRepository.existsById(track.getId()))
			throw new TrackAlreadyExistsException("Track id already exists");
		trackRepository.save(track);
			return true;
	}
	
	@Override
	public boolean deleteTrack(int id) throws TrackNotFoundException{
		if (!trackRepository.existsById(id))
			throw new TrackNotFoundException("Track not found");
		trackRepository.deleteById(id);
			return true;
	}
	
	@Override
	public List<Track> getAllTracks() {
		List<Track> trackList = trackRepository.findAll();
		return trackList;
	}
	
	@Override
	public boolean updateTrack(int id, Track track) throws TrackNotFoundException{
		if(!trackRepository.existsById(id)){
			throw new TrackNotFoundException("Track not found");
		}
		trackRepository.save(track);
		return true;
	}
	
	@Override
	public List<Track> findTrackByName(String name){
		return trackRepository.trackByName(name);
	}
}
