package com.readingisgood.readingisgoodbff.controller;


import com.readingisgood.readingisgoodbff.controller.model.*;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.service.OrderService;
import com.readingisgood.readingisgoodbff.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderOutput> order(@RequestBody OrderInput input) {
        OrderOutput output = new OrderOutput();
        try {
            CreateOrderRequest request = CreateOrderRequest.builder()
                    .customerId(input.getCustomerId())
                    .bookId(input.getBookId())
                    .count(input.getCount())
                    .build();
            orderService.order(request);
            output.setStatus(Status.SUCCESSFUL);
        } catch (ReadingIsGoodException e) {
            output.setStatus(Status.FAILURE);
            output.setMessage(e.getError().getMessage());
        }
        return ResponseEntity.ok(output);
    }

    @GetMapping("/getOrder")
    public ResponseEntity<GetOrderOutput> getOrder(@RequestBody GetOrderInput input) {
        GetOrderOutput output = new GetOrderOutput();
        try {
            GetOrderResponse getOrderResponse = orderService.getOrder(new GetOrderRequest(input.getOrderId()));
            output.setOrderDTO(getOrderResponse.getOrderDTO());
            output.setStatus(Status.SUCCESSFUL);
        } catch (ReadingIsGoodException e) {
            output.setStatus(Status.FAILURE);
            output.setMessage(e.getError().getMessage());
        }
        return ResponseEntity.ok(output);
    }

    @GetMapping("/getOrderList")
    public ResponseEntity<GetOrderListOutput> getOrderList(@RequestBody GetOrderListInput input) {
        GetOrderListOutput output = new GetOrderListOutput();
        GetOrderListResponse getOrderListResponse = orderService.getOrderList(new GetOrderListRequest(input.getStartDate(), input.getEndDate()));
        output.setOrderList(getOrderListResponse.getOrderList());
        return ResponseEntity.ok(output);
    }

}
