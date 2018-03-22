package com.movieq.random

case class Contains[T](identifier: T, value: T) extends Expression {

  override def string(): String = "(" + identifier + " contains " + value + ")"

}
