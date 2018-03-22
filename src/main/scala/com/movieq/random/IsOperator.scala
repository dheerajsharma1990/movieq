package com.movieq.random

class IsOperator(identifier: String, value: Any) extends BinaryOperator(identifier, value) {

  override def string(): String = "(" + identifier + " is " + value + ")"

}
