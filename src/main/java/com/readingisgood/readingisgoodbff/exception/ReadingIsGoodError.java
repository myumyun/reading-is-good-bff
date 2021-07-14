package com.readingisgood.readingisgoodbff.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReadingIsGoodError {
    BOOK_NOT_FOUND(1000, "Book is not found."),
    BOOK_PRICE_INVALID(1001, "Price of book is invalid."),
    UPDATE_STOCK_TO_LESS_THAN_ZERO(1002, "Stock cannot be updated to less than zero."),
    BOOK_ALREADY_EXIST_WITH_SAME_NAME(1003, "Book is already exist with the same name."),
    NOT_ENOUGH_STOCK_TO_ORDER(1004, "There is not enough stock to order."),
    ORDER_IS_INVALID(1005, "Order has invalid order id."),
    ORDER_LIST_DATE_INVALID(1006, "Dates for list orders are invalid."),
    CUSTOMER_NOT_FOUND(1007, "Customer is not found."),
    CUSTOMER_EMAIL_ALREADY_INSERTED(1008, "Customer email is already inserted.");

    private Integer code;
    private String message;
}
