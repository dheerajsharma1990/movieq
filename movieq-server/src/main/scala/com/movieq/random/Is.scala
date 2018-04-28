package com.movieq.random

case class Is[T](identifier: T, value: T) extends Expression {

  override def string(): String = "(" + identifier + " is " + value + ")"

}
