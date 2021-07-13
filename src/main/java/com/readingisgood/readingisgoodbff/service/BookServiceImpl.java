package com.readingisgood.readingisgoodbff.service;

import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodError;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.BookRepository;
import com.readingisgood.readingisgoodbff.repository.entity.Book;
import com.readingisgood.readingisgoodbff.service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final SequenceGeneratorService sequenceGeneratorService;

    @Override
    public void create(CreateBookRequest request) throws ReadingIsGoodException {
        bookRepository.findByName(request.getName())
                .ifPresent(book -> {
                    throw new ReadingIsGoodException(ReadingIsGoodError.BOOK_ALREADY_EXIST_WITH_SAME_NAME);
                });

        BigDecimal price;
        try {
            price = new BigDecimal(request.getPrice());
        } catch (NumberFormatException e) {
            throw new ReadingIsGoodException(ReadingIsGoodError.BOOK_PRICE_INVALID);
        }

        Book newBook = Book.builder()
                .id(sequenceGeneratorService.generateSequence(Book.SEQUENCE_NAME))
                .name(request.getName())
                .author(request.getAuthor())
                .price(price)
                .stock(request.getStock())
                .createdAt(new Date())
                .build();
        bookRepository.save(newBook);
    }

    @Override
    public void updateStock(UpdateStockRequest request) throws ReadingIsGoodException {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new ReadingIsGoodException(ReadingIsGoodError.BOOK_NOT_FOUND));
        if (request.getStock() < 0) {
            throw new ReadingIsGoodException(ReadingIsGoodError.UPDATE_STOCK_TO_LESS_THAN_ZERO);
        }
        book.setStock(request.getStock());
        bookRepository.save(book);
    }

    @Override
    public GetBookResponse getBook(GetBookRequest request) {
        Book book = bookRepository.findById(request.getBookId())
                .orElseThrow(() -> new ReadingIsGoodException(ReadingIsGoodError.BOOK_NOT_FOUND));
        return GetBookResponse.builder()
                .bookId(book.getId())
                .name(book.getName())
                .price(book.getPrice())
                .stock(book.getStock())
                .createdAt(book.getCreatedAt())
                .build();
    }

    @Override
    public List<Book> getBookList() {
        return bookRepository.findAll();
    }
}
