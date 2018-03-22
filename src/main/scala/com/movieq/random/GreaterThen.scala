package com.movieq.random

case class GreaterThen(identifier: String, value: Any) extends Expression {

  override def string(): String = "(" + identifier + " greaterThen " + value + ")"

}
