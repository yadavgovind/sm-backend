package com.sm.user.repository;

import com.sm.user.document.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreRepository extends MongoRepository<Store,String> {

    Store findByStoreIdOrPhone(String storeId, String phone);
}
