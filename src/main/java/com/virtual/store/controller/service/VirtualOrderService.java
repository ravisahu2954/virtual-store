package com.virtual.store.controller.service;

import java.util.List;

import com.virtual.store.form.OrderRequestForm;
import com.virtual.store.form.OrderUpdateForm;
import com.virtual.store.util.APIResponseDTO;

public interface VirtualOrderService {

	APIResponseDTO getOrders();

	APIResponseDTO getOrder(String productId);

	APIResponseDTO placeOrder(OrderRequestForm cartRequestForm);

	APIResponseDTO deleteOrder(List<String> orderId);

	APIResponseDTO updateOrder(OrderUpdateForm cartUpdateForm);

}
