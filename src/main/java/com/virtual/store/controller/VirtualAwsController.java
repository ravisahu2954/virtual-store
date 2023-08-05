package com.virtual.store.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtual.store.controller.service.VirtualAwsService;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/aws")
@RequiredArgsConstructor
@CrossOrigin("*")
public class VirtualAwsController {

	private final VirtualAwsService virtualAwsService;

	@Value("${aws.s3.bucket}")
	private String bucketName;

	@GetMapping("/{productId}")
	public ResponseEntity<APIResponseDTO> getProductDetailsFromAwsByProductId(@PathVariable String productId) {

		APIResponseDTO apiResponseDTO = virtualAwsService.getProductDetailsFromAwsByProductId(bucketName, "p-00001");
		return new ResponseEntity<>(apiResponseDTO, HttpStatus.valueOf(apiResponseDTO.getStatusCode()));
	}

}
