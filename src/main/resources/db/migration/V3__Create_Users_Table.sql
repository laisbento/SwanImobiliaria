create table users
(
    id  uuid not null constraint users_pk primary key,
    username varchar(100) not null unique,
    password varchar(200) not null
);

