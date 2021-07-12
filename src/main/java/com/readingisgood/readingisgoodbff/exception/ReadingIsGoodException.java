package com.readingisgood.readingisgoodbff.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReadingIsGoodException extends RuntimeException {
    private ReadingIsGoodError error;
}
