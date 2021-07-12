package com.readingisgood.readingisgoodbff.controller;


import com.readingisgood.readingisgoodbff.controller.model.GetStatisticsInput;
import com.readingisgood.readingisgoodbff.controller.model.GetStatisticsOutput;
import com.readingisgood.readingisgoodbff.service.StatisticsService;
import com.readingisgood.readingisgoodbff.service.model.GetStatisticsRequest;
import com.readingisgood.readingisgoodbff.service.model.GetStatisticsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @GetMapping
    public ResponseEntity<GetStatisticsOutput> getStatistics(@RequestBody GetStatisticsInput input) {
        GetStatisticsOutput output = new GetStatisticsOutput();
        GetStatisticsResponse getStatisticsResponse = statisticsService.getStatistics(new GetStatisticsRequest(input.getCustomerId()));
        output.setStatisticsList(getStatisticsResponse.getStatisticsList());
        return ResponseEntity.ok(output);
    }
}
