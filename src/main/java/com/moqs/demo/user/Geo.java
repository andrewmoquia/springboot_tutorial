package com.moqs.demo.user;

import jakarta.validation.constraints.NotNull;

public record Geo(
        @NotNull
        String lat,
        @NotNull
        String lng
) {
}
