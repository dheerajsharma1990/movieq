package com.movieq.random

import java.time.LocalDate

import com.movieq.domain.{Gender, People, ProductionCountry}

import scala.language.dynamics

object Main {

  class MovieQuery {

    def id: Identifier[Int] = {
      Identifier[Int]("movie.id")
    }

    def rating: Identifier[Double] = {
      Identifier[Double]("movie.rating")
    }

    def productionCountry: Identifier[ProductionCountry] = {
      Identifier[ProductionCountry]("movie.productionCountry")
    }

    def people: ListIdentifier[People] = {
      ListIdentifier[People]("movie.people")
    }

    def releaseDate(): Identifier[LocalDate] = {
      Identifier[LocalDate]("movie.releaseDate")
    }

  }

  class MovieqOperations {

    def search(): Search = {
      new Search
    }


    def insert(): String = {
      "insert"
    }
  }

  class Search {

    def movies(): Where = {
      new Where("search movies")
    }

  }

  class Where(val name: String) {

    def where(expression: Expression): String =  {
      name + " where " + expression.string()
    }
  }

  def movieq(): MovieqOperations = {
    new MovieqOperations
  }

  class PeopleQuery {
    def name: Identifier[String] = {
      Identifier[String]("people.name")
    }
  }

  /**
    * S -> "SEARCH" T
    * T -> ( "MOVIES" | "GENRE" | "PEOPLE" ) W
    * W ->  "WHERE" E
    * E -> "(" E "OR" E ")" | "(" E "AND" E ")" | X
    * X -> V "IS" V | V "IS NOT" V | V "CONTAINS" V
    * V -> "<STRING>"
    *
    * search movies where "id" is "124"
    * search people where ( ("id" is not "124") or ("name" contains "pqr") )
    *
    * @param args
    */
  def main(args: Array[String]) {

    val movie = new MovieQuery
    val people = new PeopleQuery

    println(movieq().search().movies().where(
      movie.id.is(124)
      .or(movie.rating.greaterThen(7.2)
        .or(movie.productionCountry.is(new ProductionCountry("US", "America"))))
      .and(people.name.contains("Salman Khan").or(movie.people.contains(new People(1, "Shahrukh", Gender.Male))))
      .or(movie.releaseDate().between(LocalDate.now().minusYears(1), LocalDate.now()))
    ))
  }
}
