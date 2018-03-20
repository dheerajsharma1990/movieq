package com.movieq.random

class Variable[T](variable: T) {

  def equalTo(other: Variable[T]): Expression = {
    new Expression(variable + " equalTo " + other)
  }

  override def toString: String = variable.toString

}

object Variable extends App {
  implicit def stringToVariable(string: String) = new Variable(string)
  implicit def intToVariable(int: Int) = new Variable(int)

  println((("abc" equalTo "mno") and (1 equalTo 4)) or ("dheeraj" equalTo "sharma"))

}
