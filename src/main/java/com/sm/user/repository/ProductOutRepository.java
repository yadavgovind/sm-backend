package com.sm.user.repository;

import com.sm.user.document.ProductOut;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductOutRepository extends MongoRepository<ProductOut,String> {
}
