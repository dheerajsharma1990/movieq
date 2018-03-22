package com.movieq.random

class GreaterThenOperator(identifier: String, value: Any) extends BinaryOperator(identifier, value) {

  override def string(): String = "(" + identifier + " greaterThen " + value + ")"

}
