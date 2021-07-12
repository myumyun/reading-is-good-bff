package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodError;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.CustomerRepository;
import com.readingisgood.readingisgoodbff.repository.OrderRepository;
import com.readingisgood.readingisgoodbff.repository.entity.Customer;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import com.readingisgood.readingisgoodbff.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final SequenceGeneratorService sequenceGeneratorService;
    private final BookService bookService;

    @Override
    public void create(CreateCustomerRequest request) {
        Customer customer = Customer.builder()
                .id(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME))
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .password(request.getPassword())
                .build();
        customerRepository.save(customer);
    }




    @Override
    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

}
