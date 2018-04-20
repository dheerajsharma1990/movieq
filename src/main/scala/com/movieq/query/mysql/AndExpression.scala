package com.movieq.query.mysql

class AndExpression(leftExpression: FilterExpression, rightExpression: FilterExpression) extends FilterExpression {

  private val and = "and"

  override def toString: String = "(" + leftExpression + " " + and + " " + rightExpression + ")"

}
