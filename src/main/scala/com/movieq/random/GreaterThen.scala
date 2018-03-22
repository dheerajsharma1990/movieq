package com.movieq.random

case class GreaterThen[T](identifier: T, value: T) extends Expression {

  override def string(): String = "(" + identifier + " greaterThen " + value + ")"

}
