package com.readingisgood.readingisgoodbff.controller.model;

import com.readingisgood.readingisgoodbff.service.model.StatisticsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetStatisticsOutput implements Serializable {
   List<StatisticsDTO> statisticsList;
}
