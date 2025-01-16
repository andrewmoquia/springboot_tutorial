package com.moqs.demo.run;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

public record Run(
        @Id @Positive
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
        Location location,
        @Version
        Integer version
) {
    public Run {
        if(startedOn.isAfter(endedOn)) {
            throw new IllegalArgumentException("The start date must be before the end date");
        }
    }
}
