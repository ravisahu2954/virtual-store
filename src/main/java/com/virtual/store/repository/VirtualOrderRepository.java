package com.virtual.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Order;

public interface VirtualOrderRepository extends MongoRepository<Order, String>{


	void deleteAllByOrderId(List<String> orderId);
	Optional<Order> findByOrderId(String orderId);
	 void deleteAllByOrderIdIn(List<String> orderIds);

}
