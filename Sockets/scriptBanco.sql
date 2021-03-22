create table marca(
	codmarca int not null,
	nomemarca varchar(40),
	primary key (codmarca));


create table bike(
	codbike int not null,
    modelobike varchar(50),
    valor decimal(10,2),
    codmarca int not null,
    primary key (codbike),
    foreign key (codmarca) references  marca (codmarca));

insert into marca (nomemarca)
values ("Caloi");
insert into marca (nomemarca)
values ("Oggi");
insert into marca (nomemarca)
values ("Groove");
insert into marca (nomemarca)
values ("Specialized");


insert into bike (modelobike,valor,codmarca)
values ("Caloi 10",1200,1);

insert into bike (modelobike,valor,codmarca)
values ("Riff50",4500,3);

insert into bike (modelobike,valor,codmarca)
values ("Sirus X 4.0",7000,4);
