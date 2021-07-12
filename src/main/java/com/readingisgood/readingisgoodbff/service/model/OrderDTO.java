package com.readingisgood.readingisgoodbff.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class OrderDTO {
    String bookName;
    int count;
    Date orderDate;
}
