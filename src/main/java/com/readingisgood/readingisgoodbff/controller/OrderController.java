package com.readingisgood.readingisgoodbff.controller;


import com.readingisgood.readingisgoodbff.controller.model.*;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import com.readingisgood.readingisgoodbff.service.CustomerService;
import com.readingisgood.readingisgoodbff.service.OrderService;
import com.readingisgood.readingisgoodbff.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<AddBookOutput> order(@RequestBody OrderInput input) {
        CreateOrderRequest request = CreateOrderRequest.builder()
                .customerId(input.getCustomerId())
                .bookId(input.getBookId())
                .count(input.getCount())
                .build();
        orderService.order(request);
        return null;
    }

    @GetMapping("/getOrder")
    public ResponseEntity<GetOrderOutput> getOrder(@RequestBody GetOrderInput input) {
        GetOrderOutput output = new GetOrderOutput();
        try {
            GetOrderResponse getOrderResponse = orderService.getOrder(new GetOrderRequest(input.getOrderId()));
            output.setOrderDTO(getOrderResponse.getOrderDTO());
            output.setStatus("successful");
        } catch (ReadingIsGoodException e) {
            output.setStatus("failure");
        }
        return ResponseEntity.ok(output);
    }

    @GetMapping
    public GetOrderListOutput getOrderList(@RequestBody GetOrderListInput input) {
        GetOrderListOutput output = new GetOrderListOutput();
        GetOrderListResponse getOrderListResponse = orderService.getOrderList(new GetOrderListRequest(input.getStartDate(), input.getEndDate()));
        return null;
    }

}
