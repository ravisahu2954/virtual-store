package com.virtual.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.store.controller.service.VirtualCaneService;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/canes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualCaneController {

	private final VirtualCaneService virtualCaneService;
	
	
	@GetMapping("/{itemId}")
	public ResponseEntity<APIResponseDTO> getItem(@PathVariable(value = "itemId") String itemId) {

		APIResponseDTO apiResponseDTO = virtualCaneService.getCane(itemId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
}
