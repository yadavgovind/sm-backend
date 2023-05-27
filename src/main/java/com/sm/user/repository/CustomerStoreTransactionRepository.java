package com.sm.user.repository;

import com.sm.user.document.CustomerStoreTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerStoreTransactionRepository extends MongoRepository<CustomerStoreTransaction,String> {
}
