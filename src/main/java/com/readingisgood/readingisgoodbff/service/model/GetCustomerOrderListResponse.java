package com.readingisgood.readingisgoodbff.service.model;

import com.readingisgood.readingisgoodbff.repository.entity.Order;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetCustomerOrderListResponse extends BaseRequest {
    List<OrderDTO> orderList;
}
