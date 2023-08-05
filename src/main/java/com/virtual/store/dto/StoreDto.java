package com.virtual.store.dto;


import java.util.List;

import com.virtual.store.entity.Store;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreDto{

	private List<Integer> pos;
	private Integer position;
	private Integer productId;
	private Integer rack;
	private Integer room;
	private List<Integer> rot;
	private List<Integer> scale;
	private Integer section;
	private Integer zone;
	
	public StoreDto(Store store)
	{
		this.pos = store.getPos();
		this.position = store.getPosition();
		this.productId = store.getProductId();
		this.rack = store.getRack();
		this.room = store.getRoom();
		this.rot = store.getRot();
		this.scale = store.getScale();
		this.section = store.getSection();
		this.zone = store.getZone();
	}
	
	
	
}
