package com.virtual.store.form;

import java.time.LocalDateTime;

import com.virtual.store.entity.Address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderUpdateForm {
	private String orderId;
	private String userId;
	private String orderName;
	private LocalDateTime orderPlaced;
	private LocalDateTime deliveryDate;
	private double total;
	private Address shipTo;
}
