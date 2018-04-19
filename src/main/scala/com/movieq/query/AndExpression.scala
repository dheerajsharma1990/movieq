package com.movieq.query

class AndExpression(leftExpression: Expression, rightExpression: Expression) extends FilterExpression {

  private val and = "and"

  override def toString: String = leftExpression + " " + and + " " + rightExpression

  override def toMySQL: String = "( " + leftExpression.toMySQL + " and " + rightExpression.toMySQL + " )"
}
