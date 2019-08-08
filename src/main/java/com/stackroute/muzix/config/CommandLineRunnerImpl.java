package com.stackroute.muzix.config;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.TrackService;
import jdk.internal.jline.internal.Log;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//implementation class for CommandLineRunner interface
@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
//	Logger instance
	private static final Logger LOG = Logger.getLogger(CommandLineRunnerImpl.class);
	public static int counter;
	
	@Autowired
	private TrackService trackService;
	
	@Override
//	seed data in database
	public void run(String...args) throws Exception {
		LOG.info("Increment counter");
		counter++;
		try {
			trackService.saveTrack(new Track(3,"ccc","ccc"));
			trackService.saveTrack(new Track(4,"ddd","ddd"));
		} catch (TrackAlreadyExistsException e) {
			Log.error(e);
		}
	}
}
