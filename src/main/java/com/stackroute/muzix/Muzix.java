package com.stackroute.muzix;

import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring boot main class
@SpringBootApplication
public class Muzix {
	
	public static void main(String[] args) {
		SpringApplication.run(Muzix.class, args);
	}
	
}