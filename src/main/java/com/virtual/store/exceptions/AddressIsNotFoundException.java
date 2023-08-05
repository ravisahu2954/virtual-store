package com.virtual.store.exceptions;

public class AddressIsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AddressIsNotFoundException(String msg) {
	  super(msg);
	}

}
