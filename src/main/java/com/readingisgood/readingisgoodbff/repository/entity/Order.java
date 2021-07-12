package com.readingisgood.readingisgoodbff.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@Document("orders")
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "orders_sequence";

    @Id
    private long id;
    private long customerId;
    private long bookId;
    private int count;
    private BigDecimal amount;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Version
    private Integer version;
}
