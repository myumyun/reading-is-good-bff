package com.readingisgood.readingisgoodbff.controller;


import com.readingisgood.readingisgoodbff.controller.model.AddBookInput;
import com.readingisgood.readingisgoodbff.controller.model.AddBookOutput;
import com.readingisgood.readingisgoodbff.controller.model.UpdateStockInput;
import com.readingisgood.readingisgoodbff.controller.model.UpdateStockOutput;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.repository.entity.Book;
import com.readingisgood.readingisgoodbff.service.BookService;
import com.readingisgood.readingisgoodbff.service.model.CreateBookRequest;
import com.readingisgood.readingisgoodbff.service.model.UpdateStockRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<AddBookOutput> add(@RequestBody AddBookInput input) {
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
            output.setStatus("successful");
        } catch (ReadingIsGoodException e) {
            output.setStatus("failure");
        }
        return ResponseEntity.ok(output);
    }

    @PostMapping("/updateStock")
    public ResponseEntity<UpdateStockOutput> updateStock(@RequestBody UpdateStockInput input) {
        UpdateStockOutput output = new UpdateStockOutput();
        try {
            UpdateStockRequest request = UpdateStockRequest.builder()
                    .bookId(input.getBookId())
                    .stock(input.getStock())
                    .build();
            bookService.updateStock(request);
            output.setStatus("successful");
        } catch (ReadingIsGoodException e) {
            output.setStatus("failure");
        }
        return ResponseEntity.ok(output);
    }

    @GetMapping("/getBookList")
    public List<Book> getBookList() {
        return bookService.getBookList();
    }
}
