package com.virtual.store.exceptions;

public class StoreItemEmptyException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public StoreItemEmptyException(String msg)
	{
		super(msg);
	}
}
