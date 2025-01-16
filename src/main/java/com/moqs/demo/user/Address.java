package com.moqs.demo.user;

import org.springframework.lang.NonNull;

public record Address(
        @NonNull
        String street,
        @NonNull
        String suite,
        @NonNull
        String city,
        @NonNull
        String zipcode,
        @NonNull
        Geo geo
) {
}
