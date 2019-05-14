create table student
(
   id integer not null,
   name varchar(255) not null,
   passport_number varchar(255) not null,
   primary key(id)
);

create table Program
(
    ID integer not null,
    NAME varchar(20) not null,
    PURPOSE varchar(255) null,
    CREATION_DATE TIMESTAMP  null,
    MEMORY_CONSUMPTION integer  null,
    IS_ACTIVE integer  null,
    primary key(ID)
);
