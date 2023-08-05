package com.virtual.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Address;

public interface VirtualAddressRepository extends MongoRepository<Address, String>{

	Optional<Address> findByUserId(String userId);

	void deleteAllByUserIdIn(List<String> orderId);

}
