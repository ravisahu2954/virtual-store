package com.virtual.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
	private String productId;
	private Long quantity;
	private Double price;
	private String desc;
	private String name;


}
