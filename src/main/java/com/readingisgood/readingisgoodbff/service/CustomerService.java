package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.entity.Customer;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import com.readingisgood.readingisgoodbff.service.model.CreateCustomerRequest;
import com.readingisgood.readingisgoodbff.service.model.CreateOrderRequest;
import com.readingisgood.readingisgoodbff.service.model.GetCustomerOrderListRequest;
import com.readingisgood.readingisgoodbff.service.model.GetCustomerOrderListResponse;

import java.util.List;

public interface CustomerService {

    void create(CreateCustomerRequest request);


    List<Order> getOrderList();
}
