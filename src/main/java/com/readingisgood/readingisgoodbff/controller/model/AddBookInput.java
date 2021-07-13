package com.readingisgood.readingisgoodbff.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddBookInput implements Serializable {
    @NotNull(message = "name of book is missing.")
    private String name;
    @NotNull(message = "price of book is missing.")
    private String price;
    private int stock;
    private String author;
    private int pageCount;
}
