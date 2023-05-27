package com.sm.user.repository;

import com.sm.user.document.RoomLotDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomLotDetailsRepository extends MongoRepository<RoomLotDetails,String> {
}
