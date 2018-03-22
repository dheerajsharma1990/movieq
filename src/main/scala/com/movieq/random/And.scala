package com.movieq.random

case class And(leftExpression: Expression, rightExpression: Expression) extends Condition(leftExpression, rightExpression) {

  override def string(): String = "(" + leftExpression.string() + " and " + rightExpression.string() + ")"

}
