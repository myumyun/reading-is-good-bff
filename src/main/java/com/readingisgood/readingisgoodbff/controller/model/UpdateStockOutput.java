package com.readingisgood.readingisgoodbff.controller.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UpdateStockOutput implements Serializable {
    private Status status;
    private String message;
}
