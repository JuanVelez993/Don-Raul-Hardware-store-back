package com.sofkau.DonRaulHardwarestoreback.repository;

import com.sofkau.DonRaulHardwarestoreback.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BillRepository extends ReactiveMongoRepository<Bill,String> {
}
