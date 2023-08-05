package com.virtual.store.exceptions;

public class UserIsNotFoundException extends RuntimeException {
  
	private static final long serialVersionUID = 1L;

	public UserIsNotFoundException(String msg)
	{
		super(msg);
	}
	
}
