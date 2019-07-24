package com.stackroute.muzix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "All details about the Track. ")
public class Track {
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	@ApiModelProperty(notes = "Track ID")
	private int id;
	
	@Column
	@ApiModelProperty(notes = "Track name")
	private String name;
	
	@Column
	@ApiModelProperty(notes = "Track comment")
	private String comment;
}
