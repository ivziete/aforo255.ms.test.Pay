create table operation (id_operation integer not null auto_increment, amount double precision not null, date varchar(255), id_invoice integer, primary key (id_operation)) engine=InnoDB