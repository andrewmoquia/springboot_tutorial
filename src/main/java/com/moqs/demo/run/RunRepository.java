package com.moqs.demo.run;

import com.moqs.demo.utilities.RunNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private final List<Run> run = new ArrayList<>();

    List<Run> findAll() {
        return run;
    }

    Optional<Run> findById(Integer id) {
        return run.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();
    }

    void create(Run run) {
        this.run.add(run);
    }

    void update(Run run) {
        Optional<Run> existingRun = findById(run.id());

        if (existingRun.isEmpty()) {
            throw new RunNotFoundException();
        }

        this.run.remove(existingRun.get());
        this.run.add(run);
    }

    void delete(Integer id) {
        Optional<Run> existingRun = findById(id);

        if (existingRun.isEmpty()) {
            throw new RunNotFoundException();
        }

        this.run.remove(existingRun.get());
    }

    @PostConstruct
    private void init() {
        run.add(new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOOR));
        run.add(new Run(2, "Evening Run", LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(2).plusMinutes(30), 10, Location.OUTDOOR));
    }
}
