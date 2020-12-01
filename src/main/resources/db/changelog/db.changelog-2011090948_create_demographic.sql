--liquibase formatted sql

--changeset xbyi:0001
create table persona_demographic (
    id int primary key auto_increment,
    name varchar(50),
    gender int,
    age int,
    telephone varchar(50),
    email varchar(50),
    address varchar(100),
    created datetime,
    updated datetime,
    created_by varchar(50),
    status int
);
--rollback drop table test
