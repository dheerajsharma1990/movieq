package com.movieq.random

case class Or(leftExpression: Expression, rightExpression: Expression) extends Expression {

  override def string(): String = "(" + leftExpression.string() + " or " + rightExpression.string() + ")"

}
