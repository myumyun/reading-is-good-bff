package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetStatisticsResponse extends BaseRequest {
    List<StatisticsDTO> statisticsList;
}
