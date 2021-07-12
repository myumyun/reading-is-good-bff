package com.readingisgood.readingisgoodbff.service.model;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest extends BaseRequest{
    private String email;
    private String password;
    private String name;
    private String surname;
}
