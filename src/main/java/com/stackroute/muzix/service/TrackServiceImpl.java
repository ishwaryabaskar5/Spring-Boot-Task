package com.stackroute.muzix.service;

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
	public boolean saveTrack(Track track) {
			trackRepository.save(track);
			return true;
	}
	
	@Override
	public boolean deleteTrack(int id) {
			trackRepository.deleteById(id);
			return true;
	}
	
	@Override
	public List<Track> getAllTracks() {
		List<Track> trackList = trackRepository.findAll();
		return trackList;
	}
	
	@Override
	public boolean updateTrack(int id, Track track) {
			if(trackRepository.existsById(id) == true){
				trackRepository.save(track);
				return true;
			}
		return false;
	}
	
	@Override
	public List<Track> findTrackByName(String name) {
		return trackRepository.trackByName(name);
	}
}
