package com.movieq.random

case class Or(leftExpression: Expression, rightExpression: Expression) extends Condition(leftExpression, rightExpression) {

  override def string(): String = "(" + leftExpression.string() + " or " + rightExpression.string() + ")"

}
