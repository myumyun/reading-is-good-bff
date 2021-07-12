package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import com.readingisgood.readingisgoodbff.service.model.*;
import org.springframework.stereotype.Service;


@Service
public interface OrderService {

    void order(CreateOrderRequest request) throws ReadingIsGoodException;

    GetOrderResponse getOrder(GetOrderRequest request) throws ReadingIsGoodException;

    GetCustomerOrderListResponse getCustomerOrderList(GetCustomerOrderListRequest request);

    GetOrderListResponse getOrderList(GetOrderListRequest request);

}
