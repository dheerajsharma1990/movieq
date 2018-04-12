package com.movieq.db


import com.movieq.domain.Genre

import scala.collection.JavaConverters._

class Converter {
  def convert[T](list: java.util.List[T]): List[T] = {
    list.asScala.toList
  }
}

object Converter extends App {
  def convert[T](list: List[T]): java.util.List[T] = {
    list.asJava
  }

  val c = new Converter
  val movieIds = convert(List[String]("297222", "376812", "14163", "21614", "127501", "325138"))
  val movieDBInput = new MovieDBInput
  val movies = c.convert(movieDBInput.getMovies(movieIds))


  val sqls = movies
    .flatMap(movie => {
      def f(genre: Genre):String = "insert into GenreInMovie (movie_id, genre_id) values (" + movie.id + ", " + genre.id + ");"
      movie.genres.toSet.map(f)
    })

  println(sqls mkString "\n")


}
