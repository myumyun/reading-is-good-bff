package com.readingisgood.readingisgoodbff.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ReadingIsGoodError {
    BOOK_NOT_FOUND(1000, "Book is not found."),
    UPDATE_STOCK_TO_LESS_THAN_ZERO(1001, "Stock cannot be updated to less than zero."),
    BOOK_ALREADY_EXIST_WITH_SAME_NAME(1002, "Book is already exist with the same name."),
    NOT_ENOUGH_STOCK_TO_ORDER(1003, "There is not enough stock to order."),
    ORDER_IS_INVALID(1004, "Order has invalid order id."),
    ORDER_LIST_DATE_INVALID(1005, "Dates for list orders are invalid.");

    private Integer code;
    private String message;
}
