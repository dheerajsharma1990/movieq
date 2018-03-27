package com.movieq.random

import com.movieq.domain.{People, ProductionCountry}

import scala.language.dynamics

object Main {

  class MovieQuery {

    def id: Identifier[Int] = {
      Identifier[Int]("id")
    }

    def rating: Identifier[Double] = {
      Identifier[Double]("rating")
    }

    def productionCountry: Identifier[ProductionCountry] = {
      Identifier[ProductionCountry]("productionCountry")
    }

    def people: ListIdentifier[People] = {
      ListIdentifier[People]("people")
    }

  }

  class PeopleQuery {
    def name: Identifier[String] = {
      Identifier[String]("people.name")
    }
  }

  def main(args: Array[String]) {

    val movie = new MovieQuery
    val people = new PeopleQuery

      movie.id.is(124)
        .or(movie.rating.greaterThen(7.2)
            .or(movie.productionCountry.is(new ProductionCountry("US", "America"))))
        .and(people.name.contains("Salman Khan").or(movie.people.contains(new People(1, "Shahrukh", 52)))
        ).string()
  }
}
