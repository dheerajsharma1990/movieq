create table Movie (id int, title varchar(255), description varchar(1000), rating decimal(10,2), release_date date, production_country_code varchar(50), primary key (id));
alter table Movie add foreign key (production_country_code) references ProductionCountry(code);