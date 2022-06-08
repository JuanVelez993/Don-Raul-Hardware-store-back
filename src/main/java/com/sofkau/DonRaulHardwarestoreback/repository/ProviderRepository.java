package com.sofkau.DonRaulHardwarestoreback.repository;

import com.sofkau.DonRaulHardwarestoreback.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProviderRepository extends ReactiveMongoRepository<Provider,String> {
}
