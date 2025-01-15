package com.moqs.demo.run;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

public record Run(
        @Positive
        Integer id,
        @NotNull
        String title,
        @NotNull
        LocalDateTime startedOn,
        @NotNull
        LocalDateTime endedOn,
         @Positive
        Integer miles,
        @NotNull
        Location location
) {
    public Run {
        if(startedOn.isAfter(endedOn)) {
            throw new IllegalArgumentException("The start date must be before the end date");
        }
    }
}
