package com.virtual.store.exceptions;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.virtual.store.util.APIResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = UserAlreadyExistException.class )
	public ResponseEntity<APIResponseDTO> handleUserAlreadyExistException()
	{
		return null;
	}
	
	@ExceptionHandler(value = StoreItemEmptyException.class )
	public ResponseEntity<APIResponseDTO> handleStoreItemEmptyException(StoreItemEmptyException storeItemEmptyException)
	{
		return new ResponseEntity<>(APIResponseDTO.builder()
				.message(storeItemEmptyException.getMessage())
				.success(false)
				.timeStamp(new Date(System.currentTimeMillis()))
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value = OrderIsNotFoundException.class)
	public ResponseEntity<APIResponseDTO> handleStoreItemEmptyException(OrderIsNotFoundException orderIsNotFoundException)
	{
		return new ResponseEntity<>(APIResponseDTO.builder()
				.message(orderIsNotFoundException.getMessage())
				.success(false)
				.timeStamp(new Date(System.currentTimeMillis()))
				.statusCode(HttpStatus.NOT_FOUND.value())
				.build(),HttpStatus.NOT_FOUND);
	}
}
