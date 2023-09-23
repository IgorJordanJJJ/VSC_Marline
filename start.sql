CREATE TABLE Person(
                       id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                       username varchar(100) NOT NULL,
                       password varchar NOT NULL,
                       role varchar(100) NOT NULL
);

INSERT INTO Person (username, "password", role) VALUES ('test_user1', 'test_password', 'ROLE_EMPL');

INSERT INTO Person (username, "password", role) VALUES ('test_user2', 'test_password', 'ROLE_EMPL');
INSERT INTO Person (username, "password", role) VALUES ('admin1', 'test_password', 'ROLE_ADMIN');