package com.virtual.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Cane")
public class Cane {

	@Id
	private String id;
	private String itemName;
	private String descriptionType;
	private String description_2;
	private String price;
	private String model_Address;
	private String name;
	private Integer specification;
	private String itemId;
	private Specs specs;
	
}








