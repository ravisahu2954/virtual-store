package com.virtual.store.dto;

import java.time.LocalDateTime;

import com.virtual.store.entity.Address;
import com.virtual.store.entity.Order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
	private String orderId;
	private String userId;
	private String orderName;
	private LocalDateTime orderPlaced;
	private LocalDateTime deliveryDate;
	private double total;
	private Address shipTo;
	
	public OrderDto(Order order)
	{
		this.orderId = order.getOrderId();
		this.userId = order.getUserId();
		this.orderName = order.getOrderName();
        this.orderPlaced = order.getOrderPlaced();
        this.deliveryDate = order.getDeliveryDate();
        this.total = order.getTotal();
        this.shipTo = order.getAddress();
	}
}
