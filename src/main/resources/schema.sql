DROP TABLE IF EXISTS sensor;

CREATE TABLE sensor(
                       id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                       name varchar(30) NOT NULL UNIQUE CHECK(length(name) BETWEEN 3 AND 30),
                       created_at timestamp NOT NULL,
                       updated_at timestamp NOT NULL,
                       created_by varchar(30) NOT NULL
);