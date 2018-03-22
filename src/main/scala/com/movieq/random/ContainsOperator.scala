package com.movieq.random

class ContainsOperator(identifier: String, value: Any) extends BinaryOperator(identifier, value) {

  override def string(): String = "(" + identifier + " contains " + value + ")"
}
