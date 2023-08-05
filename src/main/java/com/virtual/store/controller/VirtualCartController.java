package com.virtual.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.store.controller.service.VirtualCartService;
import com.virtual.store.form.CartRequestForm;
import com.virtual.store.form.CartUpdateForm;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualCartController {
	private final VirtualCartService virtualCartService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getCarts() {

		APIResponseDTO apiResponseDTO = virtualCartService.getCarts();
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@PostMapping
	public ResponseEntity<APIResponseDTO> addCart(@RequestBody CartRequestForm cartRequestForm) {

		APIResponseDTO apiResponseDTO = virtualCartService.addCart(cartRequestForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> deleteCart(@PathVariable("productId") Long productId) {

		APIResponseDTO apiResponseDTO = virtualCartService.deleteCart(productId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@PutMapping
	public ResponseEntity<APIResponseDTO> updateCart(@RequestBody CartUpdateForm cartUpdateForm) {

		APIResponseDTO apiResponseDTO = virtualCartService.updateCart(cartUpdateForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
} 
