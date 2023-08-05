package com.virtual.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.store.controller.service.VirtualOfferService;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualOfferController {

	private final VirtualOfferService virtualOfferService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getItems() {

		APIResponseDTO apiResponseDTO = virtualOfferService.getOfferItems();
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
	
}
