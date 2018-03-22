package com.movieq.random

case class Is(identifier: String, value: Any) extends Expression {

  override def string(): String = "(" + identifier + " is " + value + ")"

}
