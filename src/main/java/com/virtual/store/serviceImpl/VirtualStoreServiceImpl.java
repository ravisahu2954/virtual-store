package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualStoreService;
import com.virtual.store.dto.StoreDto;
import com.virtual.store.entity.Store;
import com.virtual.store.exceptions.StoreItemEmptyException;
import com.virtual.store.repository.VirtualStoreRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class VirtualStoreServiceImpl implements VirtualStoreService {

	private final VirtualStoreRepository virtualStoreRepository;

	@Override
	public APIResponseDTO getStoreItems() {
		List<Store> findAllStoreItem = virtualStoreRepository.findAll();
		List<StoreDto> collect = findAllStoreItem.stream().map(StoreDto::new).collect(Collectors.toList());
		return APIResponseDTO.builder().data(collect).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched all orders").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO getStoreItem(Long productId) {
		Optional<Store> findById = virtualStoreRepository.findByProductId(productId);
		if (findById.isEmpty())
			throw new StoreItemEmptyException("item is not found");
		return APIResponseDTO.builder().data(findById.get()).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched order").timeStamp(new Date(System.currentTimeMillis())).build();
	}

}
