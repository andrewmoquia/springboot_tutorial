CREATE TABLE IF NOT EXISTS Run (
    id INT NOT NULL,
    title VARCHAR(250) NOT NULL,
    started_on timestamp NOT NULL,
    ended_on timestamp NOT NULL,
    miles INT NOT NULL,
    location VARCHAR(100) NOT NULL,
    version INT,
    PRIMARY KEY (id)
);