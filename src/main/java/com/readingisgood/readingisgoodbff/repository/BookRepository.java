package com.readingisgood.readingisgoodbff.repository;

import com.readingisgood.readingisgoodbff.repository.entity.Book;
import com.readingisgood.readingisgoodbff.repository.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {
    Optional<Book> findByName(String name);
}
