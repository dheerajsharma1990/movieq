package com.movieq.random

class Variable[T](variable: T) {

  def equalTo(other: Variable[T]): Expression = {
    new Expression(variable + " equalTo " + other)
  }

  override def toString: String = variable.toString
}

