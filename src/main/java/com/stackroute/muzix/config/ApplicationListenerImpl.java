package com.stackroute.muzix.config;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.TrackService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger LOG = Logger.getLogger(ApplicationListenerImpl.class);
	public static int counter;
	
	@Autowired
	private TrackService trackService;
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		LOG.info("Increment counter");
		counter++;
		try {
			trackService.saveTrack(new Track(1,"aaa","aaa"));
			trackService.saveTrack(new Track(2,"bbb","bbb"));
		} catch (TrackAlreadyExistsException e) {
			e.printStackTrace();
		}
	}
}
