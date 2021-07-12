package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStockRequest extends BaseRequest{
   private long bookId;
   private int stock;
}
