package com.readingisgood.readingisgoodbff.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddBookInput implements Serializable {
    @NotNull
    private String name;
    private String author;
    private String price;
    private int stock;
    private int pageCount;
}
