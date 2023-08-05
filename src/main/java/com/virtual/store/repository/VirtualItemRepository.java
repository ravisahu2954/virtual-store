package com.virtual.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Item;

public interface VirtualItemRepository extends MongoRepository<Item, String>{

	List<Item> findByCategory(String category);

	Optional<Item> findByProductId(String productId);
}