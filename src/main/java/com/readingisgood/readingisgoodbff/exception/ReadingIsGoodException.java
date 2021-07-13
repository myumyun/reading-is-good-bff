package com.readingisgood.readingisgoodbff.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReadingIsGoodException extends RuntimeException {
    private ReadingIsGoodError error;
}
