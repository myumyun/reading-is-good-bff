package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderRequest extends BaseRequest{
   private long orderId;
}
