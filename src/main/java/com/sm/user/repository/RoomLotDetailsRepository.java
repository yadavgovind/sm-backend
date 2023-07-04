package com.sm.user.repository;

import com.sm.user.document.RoomLotDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomLotDetailsRepository extends MongoRepository<RoomLotDetails,String> {

    List<RoomLotDetails> findAllByRoomNoAndStoreIdAndSession( String roomId, String storeId, String sessionYear);
    List<RoomLotDetails> findAllByStoreIdAndSession(  String storeId, String sessionYear);
 }
