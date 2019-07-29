package com.stackroute.muzix.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;


/*creates a table track with id, name, comment columns using @Entity @Id @Column annotation */
/*lombok annotations @Data @AllArgsConstructor @NoArgsConstructor are used for creating constructor, getter and setter*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Track")
@ApiModel(description = "All details about the Track. ")
public class Track {
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	@ApiModelProperty(notes = "Track ID")
	private int id;
	
	@ApiModelProperty(notes = "Track name")
	private String name;
	
	@ApiModelProperty(notes = "Track comment")
	private String comment;
}
