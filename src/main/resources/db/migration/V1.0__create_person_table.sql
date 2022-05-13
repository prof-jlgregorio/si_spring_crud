create table if not exists person (
    id int not null auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    profession varchar(50) not null,
    primary key (id)
);

