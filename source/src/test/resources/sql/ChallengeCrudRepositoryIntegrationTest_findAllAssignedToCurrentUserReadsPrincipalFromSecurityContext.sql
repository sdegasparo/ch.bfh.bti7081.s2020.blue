INSERT INTO login (username, email, password)
VALUES ('test-username', 'test-email', 'test-not-bcrypted-password');

INSERT INTO patient (surname, given_name, login_username)
VALUES ('test-surname', 'test-given-name', 'test-username');

INSERT INTO challenge (name, content, criteria)
VALUES ('test-challenge-1', 'test-content', 'test-criteria'),
       ('test-challenge-2', 'test-content', 'test-criteria');

INSERT INTO patient_has_challenge (patient_id, challenge_id)
VALUES ((SELECT id FROM patient WHERE login_username = 'test-username'),
        (SELECT id FROM challenge WHERE name = 'test-challenge-1'));
