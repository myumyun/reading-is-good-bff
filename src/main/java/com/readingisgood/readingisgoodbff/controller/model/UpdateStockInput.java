package com.readingisgood.readingisgoodbff.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStockInput implements Serializable {
    @NotNull(message = "Book id is required.")
    private Long bookId;
    @NotNull(message = "Stock is required.")
    @NotEmpty(message = "Stock should be valid number.")
    private int stock;
}
