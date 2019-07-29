
package com.stackroute.muzix.repository;

import com.stackroute.muzix.model.Track;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/* creates TrackRepository which extends JpaRepository for Track Object */
@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {
	
}
