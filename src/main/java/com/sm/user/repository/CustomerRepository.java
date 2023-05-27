package com.sm.user.repository;

import com.sm.user.document.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {

   Customer  findByPhoneOrCustomerNumber(String phone, String customerNo);
   List<Customer> findAllByStoreId(String storeId);
}
