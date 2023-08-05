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

import com.virtual.store.controller.service.VirtualOrderService;
import com.virtual.store.form.OrderRequestForm;
import com.virtual.store.form.OrderUpdateForm;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualOrderController {
	private final VirtualOrderService virtualOrderService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getOrders() {

		APIResponseDTO apiResponseDTO = virtualOrderService.getOrders();
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
	@GetMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> getOrder(@PathVariable String productId) {

		APIResponseDTO apiResponseDTO = virtualOrderService.getOrder(productId);
		return new ResponseEntity<>(apiResponseDTO,  HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
	@PostMapping
	public ResponseEntity<APIResponseDTO> placeOrder(@RequestBody OrderRequestForm cartRequestForm) {

		APIResponseDTO apiResponseDTO = virtualOrderService.placeOrder(cartRequestForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
	@DeleteMapping
	public ResponseEntity<APIResponseDTO> deleteOrders(@RequestBody  List<String> orderId) {
		APIResponseDTO apiResponseDTO = virtualOrderService.deleteOrder(orderId);
		return new ResponseEntity<>(apiResponseDTO,  HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
	@PutMapping
	public ResponseEntity<APIResponseDTO> updateOrder(@RequestBody OrderUpdateForm cartUpdateForm) {

		APIResponseDTO apiResponseDTO = virtualOrderService.updateOrder(cartUpdateForm);
		return new ResponseEntity<>(apiResponseDTO,  HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
}

