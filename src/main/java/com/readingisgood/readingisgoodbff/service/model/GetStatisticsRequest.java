package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetStatisticsRequest extends BaseRequest {
    private long customerId;
}
