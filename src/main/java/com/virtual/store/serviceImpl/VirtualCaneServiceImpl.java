package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualCaneService;
import com.virtual.store.entity.Cane;
import com.virtual.store.exceptions.StoreItemEmptyException;
import com.virtual.store.repository.VirtualCaneRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VirtualCaneServiceImpl implements VirtualCaneService {

	private final VirtualCaneRepository virtualCaneRepository;

	@Override
	public APIResponseDTO getCane(String itemId) {
		Optional<Cane> findById = virtualCaneRepository.findByItemId(itemId);

		if (!findById.isPresent())
			throw new StoreItemEmptyException("item is not found " + itemId);
		return APIResponseDTO.builder().data(findById.get()).statusCode(HttpStatus.OK.value()).success(true)
				.message("added in cart").timeStamp(new Date(System.currentTimeMillis())).build();
	}

}
