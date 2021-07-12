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
public class GetCustomerOrderListInput implements Serializable {
    @NotNull
    private long customerId;
}
