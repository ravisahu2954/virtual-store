package com.virtual.store.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartUpdateForm {

	private String productId;
	private Long quantity;
	private Double price;
	private String desc;
	private Double totoal;
	
}
