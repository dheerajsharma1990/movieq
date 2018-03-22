package com.movieq.random

case class Contains(identifier: String, value: Any) extends Expression {

  override def string(): String = "(" + identifier + " contains " + value + ")"

}
