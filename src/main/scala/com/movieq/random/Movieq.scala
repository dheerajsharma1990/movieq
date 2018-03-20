package com.movieq.random

class Movieq {

  def search(expression: Expression) : Expression = {
    new Expression("search " + expression)
  }

}

object Movieq extends App {
  implicit def toVariable[T](variable: T) = new Variable(variable)

  val movieq = new Movieq
  val movies = new MovieQuery
  val query = movieq search (movies where ( "movieId" equalTo "24" ) or ("name" equalTo "Casino Royale"))
  println(query)
}
