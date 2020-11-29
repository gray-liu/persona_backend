--liquibase formatted sql

--changeset xbyi:0001
drop table if exists test;

--changeset xbyi:0002
create table test(
  id int primary key,
  name varchar(50)
);
--rollback drop table test
