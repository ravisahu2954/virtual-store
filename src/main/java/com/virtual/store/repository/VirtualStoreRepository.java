package com.virtual.store.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Store;

public interface VirtualStoreRepository extends MongoRepository<Store,String>{

	Optional<Store> findByProductId(Long id);
}
