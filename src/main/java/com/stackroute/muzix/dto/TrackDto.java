package com.stackroute.muzix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO class for Track

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackDto {
	private int id;
	
	private String name;
	
//	private String comment;
}


