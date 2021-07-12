package com.readingisgood.readingisgoodbff.controller;

import com.readingisgood.readingisgoodbff.controller.model.GetCustomerOrderListInput;
import com.readingisgood.readingisgoodbff.controller.model.GetCustomerOrderListOutput;
import com.readingisgood.readingisgoodbff.controller.model.RegisterInput;
import com.readingisgood.readingisgoodbff.controller.model.RegisterOutput;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.service.CustomerService;
import com.readingisgood.readingisgoodbff.service.OrderService;
import com.readingisgood.readingisgoodbff.service.model.CreateCustomerRequest;
import com.readingisgood.readingisgoodbff.service.model.GetCustomerOrderListRequest;
import com.readingisgood.readingisgoodbff.service.model.GetCustomerOrderListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;

    @PostMapping("/register")
    public ResponseEntity<RegisterOutput> register(@RequestBody RegisterInput input) {
        RegisterOutput output = new RegisterOutput();
        try {
            CreateCustomerRequest request = CreateCustomerRequest.builder()
                    .email(input.getEmail())
                    .password(input.getPassword())
                    .name(input.getName())
                    .surname(input.getSurname())
                    .build();
            customerService.create(request);
            output.setStatus("successful");
        } catch (ReadingIsGoodException e) {
            output.setStatus("failure");
        }
        return ResponseEntity.ok(output);
    }

    @GetMapping("/getCustomerOrderList")
    public ResponseEntity<GetCustomerOrderListOutput> getCustomerOrderList(@RequestBody GetCustomerOrderListInput input) {
        GetCustomerOrderListOutput output = new GetCustomerOrderListOutput();
        GetCustomerOrderListResponse getCustomerOrderListResponse = orderService.getCustomerOrderList(new GetCustomerOrderListRequest(input.getCustomerId()));
        output.setOrderDTOList(getCustomerOrderListResponse.getOrderList());
        return ResponseEntity.ok(output);
    }

}
