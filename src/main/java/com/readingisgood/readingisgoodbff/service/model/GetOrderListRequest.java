package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderListRequest extends BaseRequest {
    private String startDate;
    private String endDate;
}
