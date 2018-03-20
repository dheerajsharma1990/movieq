package com.movieq.random

class MovieQuery {

  def where(expression: Expression): Expression = {
    new Expression("movies where " + expression)
  }

}
