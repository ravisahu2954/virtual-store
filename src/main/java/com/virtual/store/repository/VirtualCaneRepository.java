package com.virtual.store.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Cane;

public interface VirtualCaneRepository extends  MongoRepository<Cane, String>{
  
	Optional<Cane> findByItemId(String itemId);
}
