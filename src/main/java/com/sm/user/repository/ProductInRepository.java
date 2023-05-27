package com.sm.user.repository;

import com.sm.user.document.ProductIn;
import com.sm.user.document.Store;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductInRepository extends MongoRepository<ProductIn,String> {

    List<ProductIn> findAllByLotNo(String lotNo);
    List<ProductIn> findAllByStoreIdAndRoomNo(String storeId, String roomNo);
    List<ProductIn> findAllByRoomNo(String roomNo);
    List<ProductIn> findAllByStoreId(String storeId);
}
