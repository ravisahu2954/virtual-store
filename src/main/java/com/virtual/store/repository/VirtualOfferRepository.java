package com.virtual.store.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.virtual.store.entity.Offer;

public interface VirtualOfferRepository extends MongoRepository<Offer, String> {

}
