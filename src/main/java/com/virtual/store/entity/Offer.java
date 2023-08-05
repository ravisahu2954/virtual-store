package com.virtual.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "offers")
public class Offer {

	@Id
	private String id;
	private String desc;
	private String head;
	private String time;
	
}
