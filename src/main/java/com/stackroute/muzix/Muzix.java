package com.stackroute.muzix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:application.properties"})
public class Muzix {
	
	public static void main(String[] args) {
		SpringApplication.run(Muzix.class, args);
	}
	
}