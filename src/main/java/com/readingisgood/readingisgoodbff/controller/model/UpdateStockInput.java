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
public class UpdateStockInput implements Serializable {
    @NotNull
    private Long bookId;
    @NotNull
    private int stock;
}
