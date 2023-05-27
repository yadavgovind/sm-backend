package com.sm.user.document;

import com.sm.user.constatant.MongoCollection;
import com.sm.user.document.extention.AuditDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = MongoCollection.STORE_SUBSCRIPTION)
public class RegistrationSubscription extends AuditDocument {

    @Id
    private String id;
    private String storeName;
    private String storeKey;
    private String sessionYear;
    private String status;
    private String fundStatus;

}
