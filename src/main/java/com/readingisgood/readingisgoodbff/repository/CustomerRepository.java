package com.readingisgood.readingisgoodbff.repository;

import com.readingisgood.readingisgoodbff.repository.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {

}
