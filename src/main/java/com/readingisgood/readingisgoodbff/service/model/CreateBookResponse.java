package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookResponse extends BaseRequest {
    private boolean isSuccessful;
}
