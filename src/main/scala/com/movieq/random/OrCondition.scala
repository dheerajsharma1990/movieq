package com.movieq.random

class OrCondition(leftExpression: Expression, rightExpression: Expression) extends Condition(leftExpression, rightExpression) {

  override def string(): String = "(" + leftExpression.string() + " or " + rightExpression.string() + ")"

}
