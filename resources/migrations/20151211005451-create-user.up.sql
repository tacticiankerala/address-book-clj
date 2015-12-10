CREATE TABLE IF NOT EXISTS users (
id          SERIAL,
name        VARCHAR(100) NOT NULL,
email       VARCHAR(100) NOT NULL,
PRIMARY KEY(email)
);

CREATE INDEX email_idx ON users(email);
