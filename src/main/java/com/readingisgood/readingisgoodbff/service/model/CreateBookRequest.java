package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest extends BaseRequest{
   private String name;
   private String author;
   private int pageCount;
   private int stock;
   private String price;
}
