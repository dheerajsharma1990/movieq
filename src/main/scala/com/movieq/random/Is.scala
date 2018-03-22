package com.movieq.random

case class Is(identifier: String, value: Any) extends BinaryOperator(identifier, value) {

  override def string(): String = "(" + identifier + " is " + value + ")"

}
