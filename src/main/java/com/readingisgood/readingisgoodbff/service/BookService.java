package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.service.model.*;


public interface BookService {
    void create(CreateBookRequest request) throws ReadingIsGoodException;

    void updateStock(UpdateStockRequest request) throws ReadingIsGoodException;

    GetBookResponse getBook(GetBookRequest request) throws ReadingIsGoodException;
}
