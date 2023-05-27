package com.sm.user.repository;

import com.sm.user.document.RegistrationSubscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RegistrationSubscriptionRepository extends MongoRepository<RegistrationSubscription, String> {

   RegistrationSubscription findByStoreKey(String storeKey);
}
