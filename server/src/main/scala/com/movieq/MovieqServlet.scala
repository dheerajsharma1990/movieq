package com.movieq

import org.scalatra.ScalatraServlet

class MovieqServlet extends ScalatraServlet {
  get("/search/:query") {
    val query = params("query")
    //search movie whose id is 325138

    //select movie.id, movie.description, movie.rating, movie.release_date, movie.production_country_code, productionCountry.name, genre.id, genre.name
    //from Movie movie
    //inner join ProductionCountry productionCountry on productionCountry.code = movie.production_country_code
    //inner join GenreInMovie genreInMovie on genreInMovie.movie_id = movie.id
    //inner join Genre genre on genre.id = genreInMovie.genre_id
    //where movie.id = 325138
    println(query)
  }
}
