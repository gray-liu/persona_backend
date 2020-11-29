--liquibase formatted sql

--changeset xbyi:0001
create table demographics (
    id int primary key,
    name varchar,
    gender int,
    age int,
    telephone varchar,
    email varchar,
    address varchar,
    created datetime,
    updated datetime,
    created_by varchar,
    status int
);
--rollback drop table test
