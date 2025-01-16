package com.moqs.demo.run;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {
    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);
    private final JdbcClient jdbcClient;

    public RunRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Run> findAll() {
        return jdbcClient.sql("SELECT * FROM Run")
                .query(Run.class)
                .list();
    }

    public Optional<Run> findById(Integer id) {
        //noinspection JpaQueryApiInspection
        return jdbcClient.sql("SELECT id, title, started_on, ended_on, miles, location FROM Run WHERE id = :id")
                .param("id", id)
                .query(Run.class)
                .optional();
    }

    public void create(Run run) {
        var updated = jdbcClient.sql("INSERT INTO Run(id, title, started_on, ended_on, miles, location) VALUES (?, ?, ?, ?, ?, ?)")
                .params(List.of(run.id(), run.title(), run.startedOn(), run.endedOn(), run.miles(), run.location().name()))
                .update();

        Assert.state(updated == 1, "Failed to create run" + run.title());
    }

    public void update(Run run) {
        var updated = jdbcClient.sql("UPDATE Run SET title = ?, started_on = ?, ended_on = ?, miles = ?, location = ? WHERE id = ?")
                .params(List.of(run.title(), run.startedOn(), run.endedOn(), run.miles(), run.location().name(), run.id()))
                .update();

        Assert.state(updated == 1, "Failed to update run" + run.title());
    }

    public void delete(Integer id) {
        var updated = jdbcClient.sql("DELETE FROM Run WHERE id = ?")
                .params(List.of(id))
                .update();

        Assert.state(updated == 1, "Failed to delete run" + id);
    }

    public int count() {
        return jdbcClient.sql("SELECT COUNT(*) FROM Run")
                .query()
                .listOfRows()
                .size();
    }

    public List<Run> findByLocation(Location location) {
        //noinspection JpaQueryApiInspection
        return jdbcClient.sql("SELECT * FROM Run WHERE location = :location")
                .param("location", location.name())
                .query(Run.class)
                .list();
    }
}