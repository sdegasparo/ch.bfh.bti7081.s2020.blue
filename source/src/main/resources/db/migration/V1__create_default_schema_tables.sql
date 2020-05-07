CREATE TABLE patient (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    surname VARCHAR(128) NOT NULL,
    given_name VARCHAR(128) NOT NULL,
)

CREATE TABLE login (
    username VARCHAR(32) PRIMARY KEY NOT NULL,
    email VARCHAR(64) NOT NULL,
    password CHARACTER(60) NOT NULL,
    is_enabled BOOLEAN NOT NULL DEFAULT TRUE,
    is_blocked BOOLEAN NOT NULL DEFAULT FALSE,
    patient_id BIGINT NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patient(id),
)

CREATE TABLE challenge (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL,
    content TEXT NOT NULL,
    criteria TEXT NOT NULL,
)

CREATE TABLE patient_challenges (
    patient_id BIGINT NOT NULL,
    challenge_id BIGINT NOT NULL,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (patient_id, challenge_id),
    FOREIGN KEY (patient_id) REFERENCES patient(id),
    FOREIGN KEY (challenge_id) REFERENCES challenge(id),
)

CREATE TABLE journal_entry (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    creation_date TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT now()::timestamp,
    title VARCHAR(64) NOT NULL,
    content TEXT NOT NULL,
)

CREATE TABLE patient_journal_entry (
    patient_id BIGINT NOT NULL,
    journal_entry_id BIGINT NOT NULL,
    PRIMARY KEY (patient_id, journal_id),
    FOREIGN KEY (patient_id) REFERENCES patient(id),
    FOREIGN KEY (journal_entry_id) REFERENCES journal_entry(id),
)

CREATE TABLE achievement (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL,
    description VARCHAR(256) NOT NULL,
)

CREATE TABLE patient_achieved (
    patient_id BIGINT NOT NULL,
    achievement_id BIGINT NOT NULL,
    PRIMARY KEY (patient_id, journal_id),
    FOREIGN KEY (patient_id) REFERENCES patient(id),
    FOREIGN KEY (achievement_id) REFERENCES achievement(id),
)

CREATE TABLE reward (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    name VARCHAR(64) NOT NULL,
    description TEXT NOT NULL,
    points SMALLINT NOT NULL,
    achievement_id BIGINT,
    FOREIGN KEY (achievement_id) REFERENCES achievement(id),
)

CREATE TABLE challenge_rewards (
    challenge_id BIGINT NOT NULL,
    reward_id BIGINT NOT NULL,
    PRIMARY KEY (challenge_id, reward_id),
    FOREIGN KEY (challenge_id) REFERENCES challenge(id),
    FOREIGN KEY (reward_id) REFERENCES reward(id),
)

CREATE TABLE therapist (
    title VARCHAR(128) NOT NULL,
    surname VARCHAR(128) NOT NULL,
    given_name VARCHAR(128) NOT NULL,
    street VARCHAR(256) NOT NULL,
    place VARCHAR(265) NOT NULL,
    information TEXT NOT NULL,
)
