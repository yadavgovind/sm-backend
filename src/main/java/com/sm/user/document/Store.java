package com.sm.user.document;

import com.mongodb.lang.NonNull;
import com.sm.user.constatant.MongoCollection;
import com.sm.user.document.extention.AuditDocument;
import com.sm.user.document.extention.RoomDetails;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = MongoCollection.STORE)
@Data
public class Store extends AuditDocument {
    @Id
    private String id;
    @NonNull
    private String storeName;

    private String storeId;
    @NonNull
    private String phone;
    @NonNull
    private String email;

    private String registrationSessionYear;
    @NonNull
    private Integer noOfRooms;
    private String description;
    @NonNull
    private String address;
    @NonNull
    private String registrationKey;
    @NonNull
    private String area;
    private List<RoomDetails> roomDetails;



}
