package com.virtual.store.serviceImpl;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.virtual.store.controller.service.VirtualOrderService;
import com.virtual.store.dto.OrderDto;
import com.virtual.store.entity.Order;
import com.virtual.store.exceptions.OrderIsNotFoundException;
import com.virtual.store.form.OrderRequestForm;
import com.virtual.store.form.OrderUpdateForm;
import com.virtual.store.repository.VirtualOrderRepository;
import com.virtual.store.util.APIResponseDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VirtualOrderServiceImpl implements VirtualOrderService {

	private final VirtualOrderRepository virtualOrderRepository;

	@Override
	public APIResponseDTO getOrders() {
		List<Order> findAllOrderItem = virtualOrderRepository.findAll();
		List<OrderDto> collect = findAllOrderItem.stream().map(OrderDto::new).collect(Collectors.toList());
		return APIResponseDTO.builder().data(collect).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched all orders").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO getOrder(String productId) {
		Optional<Order> order = virtualOrderRepository.findByOrderId(productId);
		if (order.isEmpty())
			throw new OrderIsNotFoundException("there is no order with this id: " + productId);
		return APIResponseDTO.builder().data(order.get()).statusCode(HttpStatus.OK.value()).success(true)
				.message("fetched order").timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO placeOrder(OrderRequestForm cartRequestForm) {

		Order cart = Order.convertToOrder(cartRequestForm);
		virtualOrderRepository.save(cart);
		return APIResponseDTO.builder().statusCode(HttpStatus.CREATED.value()).success(true).message("order is placed")
				.timeStamp(new Date(System.currentTimeMillis())).build();

	}

	@Override
	public APIResponseDTO deleteOrder(List<String> orderId) {
		orderId.forEach(ids -> {
			if (!virtualOrderRepository.findByOrderId(ids).isPresent())
				throw new OrderIsNotFoundException("there is no order with this productId : " + ids);

		});
		virtualOrderRepository.deleteAllByOrderIdIn(orderId);

		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("orders deleted")
				.timeStamp(new Date(System.currentTimeMillis())).build();
	}

	@Override
	public APIResponseDTO updateOrder(OrderUpdateForm cartUpdateForm) {

		Optional<Order> order = virtualOrderRepository.findByOrderId(cartUpdateForm.getOrderId());
		if (order.isEmpty())
			throw new OrderIsNotFoundException(
					"there is no order with this productId : " + cartUpdateForm.getOrderId());
		Order cart = Order.convertOrderUpdateFormToOrder(cartUpdateForm, order.get());
		virtualOrderRepository.save(cart);
		return APIResponseDTO.builder().statusCode(HttpStatus.OK.value()).success(true).message("order updated")
				.timeStamp(new Date(System.currentTimeMillis())).build();
	}

}