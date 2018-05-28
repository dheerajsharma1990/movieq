package com.movieq.domain

import java.time.LocalDate

class Movie(val id: Int, val title: String, val description: String, val rating: Double, val people: Set[People], val genres: Set[Genre],
            val releaseDate: LocalDate, val productionCountry: ProductionCountry) {

  def merge(movie:Movie): Movie = {
    new Movie (id, title, description, rating,
        people.++(movie.people), genres.++(movie.genres), releaseDate, productionCountry)
  }
  
}

