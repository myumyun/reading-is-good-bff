package com.readingisgood.readingisgoodbff.controller;

import com.readingisgood.readingisgoodbff.controller.model.*;
import com.readingisgood.readingisgoodbff.exception.ReadingIsGoodException;
import com.readingisgood.readingisgoodbff.security.JwtTokenProvider;
import com.readingisgood.readingisgoodbff.service.CustomerService;
import com.readingisgood.readingisgoodbff.service.OrderService;
import com.readingisgood.readingisgoodbff.service.model.CreateCustomerRequest;
import com.readingisgood.readingisgoodbff.service.model.GetCustomerOrderListRequest;
import com.readingisgood.readingisgoodbff.service.model.GetCustomerOrderListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.awt.font.LayoutPath;


@RequiredArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<RegisterOutput> register(@RequestBody RegisterInput input) {
        RegisterOutput output = new RegisterOutput();
        try {
            CreateCustomerRequest request = CreateCustomerRequest.builder()
                    .email(input.getEmail())
                    .password(passwordEncoder.encode(input.getPassword()))
                    .name(input.getName())
                    .surname(input.getSurname())
                    .build();
            customerService.create(request);
            output.setStatus(Status.SUCCESSFUL);
        } catch (ReadingIsGoodException e) {
            output.setStatus(Status.FAILURE);
            output.setMessage(e.getError().getMessage());
        }
        return ResponseEntity.ok(output);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginOutput> login(@RequestBody LoginInput input) {
        LoginOutput output = new LoginOutput();
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String accessToken = tokenProvider.generateToken(authentication);
        output.setAccessToken(accessToken);
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
