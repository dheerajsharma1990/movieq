package com.movieq.random

case class Contains(identifier: String, value: Any) extends BinaryOperator(identifier, value) {

  override def string(): String = "(" + identifier + " contains " + value + ")"
}
