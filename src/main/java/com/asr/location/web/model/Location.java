package com.asr.location.web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Location {
	
	@Id
	private int id;
	private String code;
	private String type;
	private String name;

}
