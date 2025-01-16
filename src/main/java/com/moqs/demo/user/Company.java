package com.moqs.demo.user;

import jakarta.validation.constraints.NotNull;

public record Company(
        @NotNull
        String name,
        @NotNull
        String catchPhrase,
        @NotNull
        String bs
) {
}
