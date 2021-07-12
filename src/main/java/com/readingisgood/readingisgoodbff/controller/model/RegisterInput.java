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
public class RegisterInput implements Serializable {
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String name;
    private String surname;
}
