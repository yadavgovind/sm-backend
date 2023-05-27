package com.sm.user.document.extention;

import lombok.Data;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.repository.Update;

import javax.annotation.processing.Generated;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public abstract class AuditDocument implements Serializable {

    @Version
    private Long docVerNbr;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
    @Field("_createdTimeStamp")
    @CreatedDate
    private LocalDateTime createdDateTimeStamp;
    @Field("_updatedTimeStamp")
    @LastModifiedDate
    private LocalDateTime updatedTimeStamp;
}
