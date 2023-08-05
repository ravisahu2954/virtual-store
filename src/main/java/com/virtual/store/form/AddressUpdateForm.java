package com.virtual.store.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressUpdateForm {
   
	private String id;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
}
