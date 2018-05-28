package com.movieq.db

import java.sql.ResultSet

import com.movieq.domain._


class MovieMapper {

  private val movieTableAlias = "movie"
  private val movieId = movieTableAlias + "." + "id"
  private val movieTitle = movieTableAlias + "." + "title"
  private val movieDescription = movieTableAlias + "." + "description"
  private val movieRating = movieTableAlias + "." + "rating"
  private val movieReleaseDate = movieTableAlias + "." + "release_date"

  private val productionCountryTable = "productionCountry"
  private val code = productionCountryTable + "." + "code"
  private val productionCountryName = productionCountryTable + "." + "name"

  private val peopleTableAlias: String = "people"
  private val peopleId: String = peopleTableAlias + "." + "id"
  private val peopleName: String = peopleTableAlias + "." + "name"
  private val peopleGender: String = peopleTableAlias + "." + "gender"

  private val genreTableAlias = "genre"
  private val genreId = genreTableAlias + "." + "id"
  private val genreName = genreTableAlias + "." + "name"

  def map(resultSet: ResultSet): List[Movie] = {
    new Iterator[Movie] {
      override def hasNext: Boolean = resultSet.next()
      override def next(): Movie = {
        val productionCountry = new ProductionCountry(resultSet.getString(code), resultSet.getString(productionCountryName))
        val people = new People(resultSet.getInt(peopleId), resultSet.getString(peopleName), Gender.withName(resultSet.getString(peopleGender)))
        val genre = new Genre(resultSet.getInt(genreId), resultSet.getString(genreName))
        new Movie(resultSet.getInt(movieId), resultSet.getString(movieTitle), resultSet.getString(movieDescription), resultSet.getDouble(movieRating),
          Set[People](people), Set[Genre](genre), resultSet.getDate(movieReleaseDate).toLocalDate, productionCountry)
      }
    }.toList
      .groupBy(movie => movie.id)
      .mapValues(movies => movies.reduce((m1, m2) => m1.merge(m2)))
      .values.toList
  }

}
