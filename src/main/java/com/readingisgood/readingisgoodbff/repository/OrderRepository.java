package com.readingisgood.readingisgoodbff.repository;

import com.readingisgood.readingisgoodbff.repository.entity.Book;
import com.readingisgood.readingisgoodbff.repository.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends MongoRepository<Order, Long> {
    Optional<List<Order>> findOrdersByCustomerId(long customerId);

    Optional<List<Order>> findOrdersByUpdatedAtBetween(Date startDate, Date endDate);
}
