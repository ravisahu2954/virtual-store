package com.virtual.store.dto;

import com.virtual.store.entity.Offer;

import lombok.Getter;

@Getter
public class OfferDto {

	private String desc;
	private String head;
	private String time;
	public OfferDto(Offer offer)
	{
		this.desc = offer.getDesc();
		this.head = offer.getHead();
		this.time = offer.getTime();
	}
	
}
