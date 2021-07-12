package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBookRequest extends BaseRequest{
   private long bookId;
}
