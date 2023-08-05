package com.virtual.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "items")
public class Item {

	@Id
	private String id;
	private String productId;
	private String category;
	private String desc;
	private String material_Address;
	private String model_Address;
	private String name;
	private Integer price;
	private String quantity;
	private String model_url;
	
}
