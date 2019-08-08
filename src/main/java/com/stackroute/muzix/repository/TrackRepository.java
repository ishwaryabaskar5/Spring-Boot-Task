package com.stackroute.muzix.repository;

import com.stackroute.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/* creates TrackRepository which extends JpaRepository for Track Object */
@Repository
public interface TrackRepository extends JpaRepository<Track,Integer> {

	@Query("SELECT t FROM Track t WHERE t.name = ?1")
	public List<Track> trackByName(String name);
}
