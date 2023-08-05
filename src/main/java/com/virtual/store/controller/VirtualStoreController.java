package com.virtual.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.store.controller.service.VirtualStoreService;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/stores")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualStoreController {

	private final VirtualStoreService virtualStoreService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getItems() {

		APIResponseDTO apiResponseDTO = virtualStoreService.getStoreItems();
		return new ResponseEntity<>(apiResponseDTO,HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> getItem(@PathVariable(value = "productId") Long productId) {

		APIResponseDTO apiResponseDTO = virtualStoreService.getStoreItem(productId);
		return new ResponseEntity<>(apiResponseDTO,HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
} 
