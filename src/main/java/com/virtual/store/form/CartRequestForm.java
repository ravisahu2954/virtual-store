package com.virtual.store.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartRequestForm {

	private String productId;
	private Long quantity;
	private Double oneProductPrice;
	private String desc;
	private Double totoal;
 	private String productName;
	
	
}
