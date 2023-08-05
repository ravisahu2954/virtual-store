package com.virtual.store.controller.service;

import com.virtual.store.form.CartRequestForm;
import com.virtual.store.form.CartUpdateForm;
import com.virtual.store.util.APIResponseDTO;

public interface VirtualCartService {

	APIResponseDTO getCarts();

	APIResponseDTO addCart(CartRequestForm cartRequestForm);

	APIResponseDTO deleteCart(Long productId);

	APIResponseDTO updateCart(CartUpdateForm cartUpdateForm);

}
