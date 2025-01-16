package com.moqs.demo.user;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record Login(
        @NotNull
        String uuid,
        @NotNull
        String username,
        @NotNull
        String password,
        @NotNull
        String md5,
        @NotNull
        String sha1,
        @NotNull
        LocalDateTime registered
) {
}
