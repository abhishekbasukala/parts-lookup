CREATE SCHEMA db_parts;

USE db_parts;

CREATE TABLE part
(
    id_parts BIGINT(100) NOT NULL,
    parts_name VARCHAR(45),
    parts_description VARCHAR(255),
    price_per_unit VARCHAR(45),
    date_timestamp BIGINT(200),
    PRIMARY KEY (id_parts)
);