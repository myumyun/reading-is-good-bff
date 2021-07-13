package com.readingisgood.readingisgoodbff.controller.model;

import com.readingisgood.readingisgoodbff.service.model.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetOrderListOutput implements Serializable {
    List<OrderDTO> orderList;
}
