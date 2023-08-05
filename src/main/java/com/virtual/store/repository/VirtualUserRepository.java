package com.virtual.store.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.User;

public interface VirtualUserRepository extends MongoRepository<User, String> {

	void deleteAllById(List<String> userId);

	Optional<User> findById(String userId);

	void deleteAllByIdIn(List<String> userIds);
}
