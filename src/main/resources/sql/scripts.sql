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

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(200) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO customers (email, password, role)
VALUES ('happy@example.com', 'qwerty', 'admin');

