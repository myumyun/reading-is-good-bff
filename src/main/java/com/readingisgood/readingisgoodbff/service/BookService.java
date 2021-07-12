package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.entity.Book;
import com.readingisgood.readingisgoodbff.service.model.*;

import java.util.List;

public interface BookService {
    void create(CreateBookRequest request) throws ReadingIsGoodException;

    void updateStock(UpdateStockRequest request) throws ReadingIsGoodException;

    GetBookResponse getBook(GetBookRequest request) throws ReadingIsGoodException;

    List<Book> getBookList();
}
