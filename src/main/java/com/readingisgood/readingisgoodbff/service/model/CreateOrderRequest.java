package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest extends BaseRequest{
   private long customerId;
   private long bookId;
   private int count;
}
