package com.virtual.store.util;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@JsonInclude(Include.NON_NULL)
public class APIResponseDTO {

	private final String message;

	private final boolean success;

	private final String status;

	private final Date timeStamp;

	private final int statusCode;

	private Object data;
	
	private final Double total;

}
