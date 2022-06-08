package com.sofkau.DonRaulHardwarestoreback.repository;

import com.sofkau.DonRaulHardwarestoreback.collection.Receipt;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReceiptRepository extends ReactiveMongoRepository<Receipt,String> {
}
