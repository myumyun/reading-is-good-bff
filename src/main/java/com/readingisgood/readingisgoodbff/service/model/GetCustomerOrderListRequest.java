package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerOrderListRequest extends BaseRequest {
    private long customerId;
}
