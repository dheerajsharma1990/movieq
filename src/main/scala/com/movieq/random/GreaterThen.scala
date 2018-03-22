package com.movieq.random

case class GreaterThen(identifier: String, value: Any) extends BinaryOperator(identifier, value) {

  override def string(): String = "(" + identifier + " greaterThen " + value + ")"

}
