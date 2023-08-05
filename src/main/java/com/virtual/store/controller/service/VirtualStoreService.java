package com.virtual.store.controller.service;

import com.virtual.store.util.APIResponseDTO;

public interface VirtualStoreService {

	APIResponseDTO getStoreItems();

	APIResponseDTO getStoreItem(Long productId);

}
