package com.sm.user.controller;


import com.sm.user.document.RegistrationSubscription;
import com.sm.user.document.Store;
import com.sm.user.repository.RegistrationSubscriptionRepository;
import com.sm.user.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/store")
public class StoreController {
@Autowired
    private StoreRepository storeRepository;
@Autowired
private RegistrationSubscriptionRepository subscriptionRepository;


    @PostMapping("/")
    public ResponseEntity<Store> create(@RequestBody Store store){
        if(store.getRegistrationSessionYear()==null){
            store.setRegistrationSessionYear(String.valueOf(LocalDate.now().getYear()));
        }
        Store store1= storeRepository.findByStoreIdOrPhone(store.getStoreId(),store.getPhone());
      if(ObjectUtils.isEmpty(store1)) {
          store.setCreatedDateTimeStamp(LocalDateTime.now());
          store.setUpdatedTimeStamp(LocalDateTime.now());
         return  ResponseEntity.ok(storeRepository.save(store));
      }
        RegistrationSubscription subscription = subscriptionRepository.findByStoreKey(store.getRegistrationKey());
      if(!(store.getRegistrationKey().equals(subscription.getStoreKey()) && subscription.getStatus().equals("ACTIVE"))){
          return ResponseEntity.badRequest().eTag("Failed due to invalid key").build();
      }
      store.setId(store1.getId());
        store.setStoreId(store1.getStoreId());
        store.setPhone(store1.getPhone());
        store.setDocVerNbr(store1.getDocVerNbr()+1);
        store.setUpdatedTimeStamp(LocalDateTime.now());
        return  ResponseEntity.ok( storeRepository.save(store));
    }


}
