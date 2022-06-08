package com.sofkau.DonRaulHardwarestoreback.repository;

import com.sofkau.DonRaulHardwarestoreback.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product,String> {
}
