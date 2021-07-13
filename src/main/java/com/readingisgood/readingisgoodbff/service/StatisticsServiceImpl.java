package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodError;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.OrderRepository;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import com.readingisgood.readingisgoodbff.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
public class StatisticsServiceImpl implements StatisticsService {
    private final OrderRepository orderRepository;

    @Override
    public GetStatisticsResponse getStatistics(GetStatisticsRequest request) {
        GetStatisticsResponse response = new GetStatisticsResponse();
        Map<String, List<Order>> orderMap = new HashMap<>();
        Optional<List<Order>> orderList = orderRepository.findOrdersByCustomerId(request.getCustomerId());
        if (orderList.isPresent()) {
            for (Order order : orderList.get()) {
                String month = new SimpleDateFormat("MMM").format(order.getUpdatedAt());
                List<Order> monthlyOrderList = orderMap.getOrDefault(month, new ArrayList<>());
                monthlyOrderList.add(order);
                orderMap.put(month, monthlyOrderList);
            }
            List<StatisticsDTO> statisticsList = new ArrayList<>();
            for (String month : orderMap.keySet()) {
                List<Order> monthlyOrderList = orderMap.get(month);
                int bookCount = 0;
                BigDecimal purchaseAmount = BigDecimal.ZERO;
                for (Order order : monthlyOrderList) {
                    bookCount += order.getCount();
                    purchaseAmount.add(order.getAmount());
                }
                StatisticsDTO statistics = StatisticsDTO.builder()
                        .month(month)
                        .orderCount(monthlyOrderList.size())
                        .bookCount(bookCount)
                        .purchasedAmount(purchaseAmount)
                        .build();
                statisticsList.add(statistics);
            }
            response.setStatisticsList(statisticsList);
        }
        return response;
    }


}
