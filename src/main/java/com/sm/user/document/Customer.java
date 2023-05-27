package com.sm.user.document;

import com.sm.user.constatant.MongoCollection;
import com.sm.user.document.extention.Address;
import com.sm.user.document.extention.AuditDocument;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = MongoCollection.CUSTOMER)
public class Customer extends AuditDocument {

    @Id
    private String id;
    private String customerNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String phone;
    private String email;
    private String vehicleNumber;
    private String customerType;
    private String storeId;
    private String registerSession;
    private List<Address> addresses;


}
