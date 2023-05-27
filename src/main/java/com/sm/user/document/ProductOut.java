package com.sm.user.document;

import com.sm.user.constatant.MongoCollection;
import com.sm.user.document.extention.AuditDocument;
import com.sm.user.document.extention.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = MongoCollection.PRODUCT_OUT)
public class ProductOut extends AuditDocument {

    @Id
         private String id;
           private String productNumber;
            private String lotNo;
            private String quantity;
           private Product product;
            private String reasonOfOut;
            private String soldToBossinessMan;

}
