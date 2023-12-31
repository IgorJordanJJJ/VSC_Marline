CREATE TABLE Person(
                       id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                       username varchar(100) NOT NULL,
                       password varchar NOT NULL,
                       role varchar(100) NOT NULL
);


CREATE TABLE GitRepositories(
                       id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                       name varchar(30) NOT NULL,
                       text_programm varchar,
                       command varchar(20) NOT NULL
);

CREATE TABLE CICDDeployment(
                                id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                                status varchar NOT NULL,
                                platform varchar(30) NOT NULL,
                                command varchar(20) NOT NULL
);

CREATE TABLE Application (
                               id int PRIMARY KEY GENERATED BY DEFAULT AS IDENTITY,
                               id_user int references Person(id) on delete set null,
                               name varchar(30) NOT NULL,
                               id_gitrepository int references GitRepositories(id) on delete set null,
                               id_CI_CD int references CICDDeployment(id) on delete set null
);

drop table Application;