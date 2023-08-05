package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualOfferService;
import com.virtual.store.dto.OfferDto;
import com.virtual.store.entity.Offer;
import com.virtual.store.repository.VirtualOfferRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VirtualOfferServiceImpl implements VirtualOfferService{

	private final VirtualOfferRepository virtualOfferRepository;
	
	@Override
	public APIResponseDTO getOfferItems() {
		List<Offer> findAllOfferItem = virtualOfferRepository.findAll();
		List<OfferDto> collect = findAllOfferItem.stream().map(OfferDto::new).collect(Collectors.toList());
		return APIResponseDTO.builder()
				             .data(collect)
				             .statusCode(HttpStatus.OK.value()).success(true)
								.message("fetched all orders").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	
	
}
