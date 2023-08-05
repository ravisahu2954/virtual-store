package com.virtual.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {
	private String id;
	private String userId;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
}
