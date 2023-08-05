package com.virtual.store.controller.service;

import java.util.List;

import com.virtual.store.form.AddressRequestForm;
import com.virtual.store.form.AddressUpdateForm;
import com.virtual.store.util.APIResponseDTO;

public interface VirtualAddressService {
	APIResponseDTO getAddresss();

	APIResponseDTO getAddress(String productId);

	APIResponseDTO deleteAddress(List<String> orderId);

	APIResponseDTO updateAddress(AddressUpdateForm cartUpdateForm);

	APIResponseDTO addAddress(AddressRequestForm addressRequestForm);
}
