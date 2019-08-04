package com.stackroute.muzix.config;

import org.jboss.logging.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class ApplicationListenerImpl implements ApplicationListener<ContextRefreshedEvent> {
	
	private static final Logger LOG = Logger.getLogger(ApplicationListenerImpl.class);
	public static int counter;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		LOG.info("Increment counter");
		counter++;
	}
}
