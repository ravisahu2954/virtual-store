package com.virtual.store.dto;

import com.virtual.store.entity.Item;

import lombok.Getter;

@Getter
public class ItemDto {

	private String productId;
	private String category;
	private String desc;
	private String material_Address;
	private String model_Address;
	private String name;
	private Integer price;
	private String quantity;
	private String model_url;

	public ItemDto(Item item) {
		this.productId = item.getProductId();
		this.category = item.getCategory();
		this.desc = item.getDesc();
		this.material_Address = item.getMaterial_Address();
		this.model_Address = item.getModel_Address();
		this.name = item.getName();
		this.price = item.getPrice();
		this.quantity = item.getQuantity();
		this.model_url = item.getModel_url();
	}
} 
