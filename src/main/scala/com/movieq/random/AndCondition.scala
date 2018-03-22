package com.movieq.random

class AndCondition(leftExpression: Expression, rightExpression: Expression) extends Condition(leftExpression, rightExpression) {

  override def string(): String = "(" + leftExpression.string() + " and " + rightExpression.string() + ")"

}
