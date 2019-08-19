package com.stackroute.muzix;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@Slf4j          // abstraction framework for logging
@EnableCaching  // enables caching for this spring boot application
public class Muzix {
	
	public static void main(String[] args) {
		SpringApplication.run(Muzix.class, args);
	}
	
//	ModelMapper bean for mapping b/w entity to DTO and vice versa
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}

