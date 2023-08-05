package com.virtual.store.controller;

import java.util.List;

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

import com.virtual.store.controller.service.VirtualAddressService;
import com.virtual.store.form.AddressRequestForm;
import com.virtual.store.form.AddressUpdateForm;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualAddressController {
	private final VirtualAddressService virtualAddressService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getAddresss() {

		APIResponseDTO apiResponseDTO = virtualAddressService.getAddresss();
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@GetMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> getAddress(@PathVariable String productId) {

		APIResponseDTO apiResponseDTO = virtualAddressService.getAddress(productId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@PostMapping
	public ResponseEntity<APIResponseDTO> addNewAddress(@RequestBody AddressRequestForm addressRequestForm) {

		APIResponseDTO apiResponseDTO = virtualAddressService.addAddress(addressRequestForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@DeleteMapping
	public ResponseEntity<APIResponseDTO> deleteAddresss(@RequestBody List<String> orderId) {
		APIResponseDTO apiResponseDTO = virtualAddressService.deleteAddress(orderId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@PutMapping
	public ResponseEntity<APIResponseDTO> updateAddress(@RequestBody AddressUpdateForm cartUpdateForm) {

		APIResponseDTO apiResponseDTO = virtualAddressService.updateAddress(cartUpdateForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
}
