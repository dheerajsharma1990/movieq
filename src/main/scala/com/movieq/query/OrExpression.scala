package com.movieq.query

class OrExpression(leftExpression: Expression, rightExpression: Expression) extends Expression {

  private val or = "or"

  override def toString: String = leftExpression + " " + or + " " + rightExpression

}
