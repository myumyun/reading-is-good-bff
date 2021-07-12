package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBookResponse extends BaseRequest {
    private long bookId;
    private String name;
    private int stock;
    private BigDecimal price;
    private Date createdAt;
}
