package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualItemService;
import com.virtual.store.dto.ItemDto;
import com.virtual.store.entity.Item;
import com.virtual.store.exceptions.StoreItemEmptyException;
import com.virtual.store.repository.VirtualItemRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.services.s3.S3Client;

@Service
@RequiredArgsConstructor
public class VirtualItemServiceImpl implements VirtualItemService {

	private final VirtualItemRepository virtualItemRepository;

	private final S3Client s3Client;

	@Override
	public APIResponseDTO getItems(Integer page,Integer size) {
		Page<Item> findAllItem = virtualItemRepository.findAll(PageRequest.of(page, size));
		List<ItemDto> collect = findAllItem.stream().map(ItemDto::new).collect(Collectors.toList());
		
		return APIResponseDTO.builder().data(collect).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched all items").timeStamp(new Date(System.currentTimeMillis())).build();

	}

	@Override
	public APIResponseDTO getItem(String productId) {
		Optional<Item> item = virtualItemRepository.findByProductId(productId);
		if (!item.isPresent())
			throw new StoreItemEmptyException("item is not found");
		return APIResponseDTO.builder().data(item.get()).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched item detail").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO getItemByCategory(String category) {

		List<Item> findByCategory = virtualItemRepository.findByCategory(category);
		if (findByCategory.isEmpty())
			throw new StoreItemEmptyException("item is not found");
		return APIResponseDTO.builder().data(findByCategory).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched items by " + category).timeStamp(new Date(System.currentTimeMillis())).build();

	}

}
