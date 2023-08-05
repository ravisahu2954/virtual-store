package com.virtual.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.store.controller.service.VirtualItemService;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualItemController {

	private final VirtualItemService virtualItemService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getItems(@RequestParam(name = "page", defaultValue = "0") final Integer page,
			@RequestParam(name = "size", defaultValue = "10") final Integer size) {

		APIResponseDTO apiResponseDTO = virtualItemService.getItems(page,size);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@GetMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> getItem(@PathVariable(value = "productId") String productId) {

		APIResponseDTO apiResponseDTO = virtualItemService.getItem(productId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@GetMapping("category/{category}")
	public ResponseEntity<APIResponseDTO> getItemByCategory(@PathVariable(value = "category") String category) {

		APIResponseDTO apiResponseDTO = virtualItemService.getItemByCategory(category);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

}
