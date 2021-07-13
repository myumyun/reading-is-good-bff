package com.readingisgood.readingisgoodbff.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@Document("books")
public class Book {
    @Transient
    public static final String SEQUENCE_NAME = "books_sequence";

    @Id
    private long id;
    @Indexed(unique = true)
    private String name;
    private String author;
    private int pageCount;
    private int stock;
    private BigDecimal price;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
