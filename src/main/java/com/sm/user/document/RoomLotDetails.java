package com.sm.user.document;

import com.sm.user.constatant.MongoCollection;
import com.sm.user.document.extention.AuditDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = MongoCollection.ROOM_LOT_DETAILS)
@Data
public class RoomLotDetails extends AuditDocument {
    @Id
    private String id;
    private String storeId;
    private String generatedLotName;
    private Integer lotCapacity;
    private Integer floorNo;
    private String roomId;
    private Integer lotStatus;
    private String session;
    private String status;
    private String allocatedCustomer;
}
