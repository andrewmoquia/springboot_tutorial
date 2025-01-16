package com.moqs.demo.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;

import java.net.URL;
import java.time.LocalDate;

public record User(
    @Id @NotNull @Positive
    Integer id,
    @NotNull
    String firstname,
    @NotNull
    String lastname,
    @NotNull
    Email email,
    @NotNull
    LocalDate birthDate,
    @NotNull
    Login login,
    @NotNull
    Address address,
    @NotNull
    Integer phone,
    @NotNull
    URL website,
    @NotNull
    Company company
) {
}
