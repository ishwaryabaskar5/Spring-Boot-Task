package com.stackroute.muzix.config;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.TrackService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	private static final Logger LOG = Logger.getLogger(CommandLineRunnerImpl.class);
	public static int counter;
	
	@Autowired
	private TrackService trackService;
	
	@Override
	public void run(String...args) throws Exception {
		LOG.info("Increment counter");
		counter++;
		try {
			trackService.saveTrack(new Track(3,"ccc","ccc"));
			trackService.saveTrack(new Track(4,"ddd","ddd"));
		} catch (TrackAlreadyExistsException e) {
			e.printStackTrace();
		}
	}
}
