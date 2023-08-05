package com.virtual.store.controller.service;

import com.virtual.store.util.APIResponseDTO;

public interface VirtualItemService {

	APIResponseDTO getItems(Integer page,Integer size);

	APIResponseDTO getItem(String productId);

	APIResponseDTO getItemByCategory(String category);

}
