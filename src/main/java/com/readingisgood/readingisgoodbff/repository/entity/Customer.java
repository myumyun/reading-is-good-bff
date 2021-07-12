package com.readingisgood.readingisgoodbff.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@Document("customers")
public class Customer {
    @Transient
    public static final String SEQUENCE_NAME = "customers_sequence";

    @Id
    private long id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String name;
    private String surname;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @Version
    private Integer version;
}
