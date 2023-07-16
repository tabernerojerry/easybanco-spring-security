CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    enabled INT NOT NULL
);

CREATE TABLE authorities (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL
);

INSERT INTO users VALUES (NULL, 'happy', 'qwerty', '1');
INSERT INTO authorities VALUES (NULL, 'happy', 'write');

