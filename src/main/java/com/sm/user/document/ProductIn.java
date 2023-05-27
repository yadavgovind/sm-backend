package com.sm.user.document;

import com.sm.user.constatant.MongoCollection;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = MongoCollection.PRODUCT_IN)
@Data
public class ProductIn {

            @Id
            private String id;
            private String productNumber;
            private String productName;
            private String product_type;
            private String quality_name ;
            private String quantity;
            private String lotNo;
            private String roomNo;
            private String currentQuantity;
            private String customerNumber;
            private String session;
            private String storeId;

}
