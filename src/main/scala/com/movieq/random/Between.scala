package com.movieq.random

case class Between[T](identifier: T, value1: T, value2: T) extends Expression {

  override def string(): String = "(" + identifier + " between (" + value1 + "," + value2 + ")" + ")"

}
