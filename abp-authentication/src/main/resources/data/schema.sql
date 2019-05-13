
create table test_user_table (
    id int not null primary key auto_increment,
    name varchar(32) not null comment 'The name',
    age int not null comment 'Age of the user'
    gmt_create datetime not null,
    gmt_modify datetime not null
) comment 'An test table, no real usage';

