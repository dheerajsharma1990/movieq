alter table PeopleInMovie add foreign key (movie_id) references Movie(id);
alter table PeopleInMovie add foreign key (people_id) references People(id);