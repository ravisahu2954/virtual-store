package com.virtual.store.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection  = "store")
public class Store {

	@Id
	private String id;
	private List<Integer> pos;
	private Integer position;
	private Integer productId;
	private Integer rack;
	private Integer room;
	private List<Integer> rot;
	private List<Integer> scale;
	private Integer section;
	private Integer zone;
	
}
