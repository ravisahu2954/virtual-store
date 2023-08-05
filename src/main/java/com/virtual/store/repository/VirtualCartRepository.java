package com.virtual.store.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Cart;

public interface VirtualCartRepository extends MongoRepository<Cart, String>{

	void deleteByProductId(Long productId);

	Optional<Cart> findByProductId(String productId);

}
