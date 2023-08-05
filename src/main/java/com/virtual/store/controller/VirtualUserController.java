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

import com.virtual.store.controller.service.VirtualUserService;
import com.virtual.store.form.UserRequestForm;
import com.virtual.store.form.UserUpdateForm;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualUserController {
	private final VirtualUserService virtualUserService;

	@GetMapping
	public ResponseEntity<APIResponseDTO> getUsers() {

		APIResponseDTO apiResponseDTO = virtualUserService.getUsers();
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@GetMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> getUser(@PathVariable String productId) {

		APIResponseDTO apiResponseDTO = virtualUserService.getUser(productId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@PostMapping
	public ResponseEntity<APIResponseDTO> addUser(@RequestBody UserRequestForm cartRequestForm) {

		APIResponseDTO apiResponseDTO = virtualUserService.addUser(cartRequestForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@DeleteMapping
	public ResponseEntity<APIResponseDTO> deleteUsers(@RequestBody List<String> userId) {
		APIResponseDTO apiResponseDTO = virtualUserService.deleteUser(userId);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

	@PutMapping
	public ResponseEntity<APIResponseDTO> updateUser(@RequestBody UserUpdateForm cartUpdateForm) {

		APIResponseDTO apiResponseDTO = virtualUserService.updateUser(cartUpdateForm);
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}
}
