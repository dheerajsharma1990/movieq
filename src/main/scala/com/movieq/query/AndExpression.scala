package com.movieq.query

class AndExpression(leftExpression: Expression, rightExpression: Expression) extends Expression {

  private val and = "and"

  override def toString: String = leftExpression + " " + and + " " + rightExpression

}
