package com.virtual.store.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virtual.store.form.AddressUpdateForm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "address")
public class Address {

	@Id
	@JsonIgnore
	private String id;
	@JsonIgnore
	private String userId;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	public static Address convertAddressUpdateFormToAddress(AddressUpdateForm cartUpdateForm, Address address) {
		
		address.setStreet(cartUpdateForm.getStreet());
		address.setCity(cartUpdateForm.getCity());
		address.setState(cartUpdateForm.getState());
		address.setZipCode(cartUpdateForm.getZipCode());
        address.setCountry(cartUpdateForm.getCountry());
		
		return address;
	}

} 
