package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodError;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.CustomerRepository;
import com.readingisgood.readingisgoodbff.repository.OrderRepository;
import com.readingisgood.readingisgoodbff.repository.entity.Customer;
import com.readingisgood.readingisgoodbff.service.model.CreateCustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void create(CreateCustomerRequest request) {
        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new ReadingIsGoodException(ReadingIsGoodError.CUSTOMER_EMAIL_ALREADY_INSERTED);
        }
        Customer customer = Customer.builder()
                .id(sequenceGeneratorService.generateSequence(Customer.SEQUENCE_NAME))
                .email(request.getEmail())
                .name(request.getName())
                .surname(request.getSurname())
                .password(request.getPassword())
                .build();
        customerRepository.save(customer);
    }

}
