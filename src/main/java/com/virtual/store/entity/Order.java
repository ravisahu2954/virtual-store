package com.virtual.store.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.virtual.store.form.OrderRequestForm;
import com.virtual.store.form.OrderUpdateForm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

	@Id
	private String id;
	private String userId;
	private String orderId;
	private String orderName;
	private LocalDateTime orderPlaced;
	private LocalDateTime deliveryDate;
	private double total;
	private Address address;

	public static Order convertToOrder(OrderRequestForm orderRequestForm) {
		var order = new Order();
		order.setOrderId(orderRequestForm.getOrderId());
		order.setUserId(orderRequestForm.getUserId());
		order.setOrderName(orderRequestForm.getOrderName());
		order.setOrderPlaced(LocalDateTime.now());
		order.setDeliveryDate(orderRequestForm.getDeliveryDate());
		order.setTotal(orderRequestForm.getTotal());

		var shipTo = new Address();
		var address = orderRequestForm.getShipTo();
		shipTo.setStreet(address.getStreet());
		shipTo.setState(address.getState());
		shipTo.setCity(address.getCity());
		shipTo.setZipCode(address.getZipCode());
		shipTo.setCountry(address.getCountry());

		order.setAddress(shipTo);

		return order;
	}

	public static Order convertOrderUpdateFormToOrder(OrderUpdateForm orderUpdateForm,Order order) {
		
		order.setOrderName(orderUpdateForm.getOrderName());
		order.setUserId(orderUpdateForm.getUserId());
		order.setOrderPlaced(LocalDateTime.now());
		order.setDeliveryDate(orderUpdateForm.getDeliveryDate());
		order.setTotal(orderUpdateForm.getTotal());

		var shipTo = new Address();
		var address = orderUpdateForm.getShipTo();
		shipTo.setState(address.getState());
		shipTo.setStreet(address.getStreet());
		shipTo.setCity(address.getCity());
		shipTo.setZipCode(address.getZipCode());
		shipTo.setCountry(address.getCountry());

		order.setAddress(shipTo);

		return order;
	}

}
