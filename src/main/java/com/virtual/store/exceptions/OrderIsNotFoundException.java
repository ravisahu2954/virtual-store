package com.virtual.store.exceptions;

public class OrderIsNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OrderIsNotFoundException(String msg)
	{
		super(msg);
	}

}
