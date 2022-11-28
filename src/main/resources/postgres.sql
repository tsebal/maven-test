CREATE DATABASE "game";

CREATE SCHEMA "data_storage";

DROP TABLE data_storage."localuser";

CREATE TABLE data_storage.localuser
(
    id       BIGINT PRIMARY KEY,
    login    VARCHAR(128),
    password VARCHAR(128),
    role     VARCHAR(32)
);

INSERT INTO data_storage.localuser(id, login, password, role)
VALUES (1, 'Ivan', '245', 'ADMIN');