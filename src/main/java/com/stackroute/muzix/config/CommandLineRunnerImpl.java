package com.stackroute.muzix.config;

import org.jboss.logging.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
	private static final Logger LOG = Logger.getLogger(CommandLineRunnerImpl.class);
	public static int counter;

	@Override
	public void run(String...args) throws Exception {
		LOG.info("Increment counter");
		counter++;
	}
}
