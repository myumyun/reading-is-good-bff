package com.readingisgood.readingisgoodbff.controller;


import com.readingisgood.readingisgoodbff.controller.model.*;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.entity.Book;
import com.readingisgood.readingisgoodbff.service.BookService;
import com.readingisgood.readingisgoodbff.service.model.CreateBookRequest;
import com.readingisgood.readingisgoodbff.service.model.UpdateStockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<AddBookOutput> add(@Valid @RequestBody AddBookInput input) {
        AddBookOutput output = new AddBookOutput();
        try {
            CreateBookRequest request = CreateBookRequest.builder()
                    .name(input.getName())
                    .author(input.getAuthor())
                    .stock(input.getStock())
                    .pageCount(input.getPageCount())
                    .price(input.getPrice())
                    .build();
            bookService.create(request);
            output.setStatus(Status.SUCCESSFUL);
        } catch (ReadingIsGoodException e) {
            output.setStatus(Status.FAILURE);
            output.setMessage(e.getError().getMessage());
        }
        return ResponseEntity.ok(output);
    }

    @PostMapping("/updateStock")
    public ResponseEntity<UpdateStockOutput> updateStock(@Valid @RequestBody UpdateStockInput input) {
        UpdateStockOutput output = new UpdateStockOutput();
        try {
            UpdateStockRequest request = UpdateStockRequest.builder()
                    .bookId(input.getBookId())
                    .stock(input.getStock())
                    .build();
            bookService.updateStock(request);
            output.setStatus(Status.SUCCESSFUL);
        } catch (ReadingIsGoodException e) {
            output.setStatus(Status.FAILURE);
            output.setMessage(e.getError().getMessage());
        }
        return ResponseEntity.ok(output);
    }
}
