package com.readingisgood.readingisgoodbff.controller.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class GetStatisticsInput implements Serializable {
    private long customerId;
}
