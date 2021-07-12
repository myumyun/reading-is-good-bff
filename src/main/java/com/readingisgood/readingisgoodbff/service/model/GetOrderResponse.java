package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderResponse extends BaseRequest {
    private OrderDTO orderDTO;
}
