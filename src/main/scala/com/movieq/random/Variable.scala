package com.movieq.random

class Variable[T](variable: T) {

  def equalTo(other: Variable[T]): Expression = {
    new Expression(variable + " equalTo " + other)
  }

}

object Variable extends App {
  implicit def stringToVariable(string: String) = new Variable(string)

  implicit def intToVariable(int: Int) = new Variable(int)

  val abc = new Variable("abc")
  val pqr = new Variable("pqr")
  val movieId = 214
  (("abc" equalTo "mno") and (movieId equalTo 4)) or ("dheeraj" equalTo "sharma")

}
