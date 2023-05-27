package com.sm.user.document;

import com.sm.user.constatant.MongoCollection;
import com.sm.user.document.extention.AuditDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = MongoCollection.CUSTOMER_STORE_TRANSACTION)
public class CustomerStoreTransaction extends AuditDocument {

    @Id
    private String id;
    private String customerNumber;
    private Double storeCharge;
    private LocalDateTime chargeStartDate;
    private LocalDateTime chargeEndDate;
    private String chargeType;
    private Double amount;
    private Integer quantity;
    private Integer rate;
    private String description;
    private Integer interestRate;
    private String lotNo;
    private String storeId;
}
