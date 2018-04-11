alter table GenreInMovie add foreign key (movie_id) references Movie(id);
alter table GenreInMovie add foreign key (genre_id) references Genre(id);