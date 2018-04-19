package com.movieq.query

class OrExpression(leftExpression: Expression, rightExpression: Expression) extends FilterExpression {

  private val or = "or"

  override def toString: String = leftExpression + " " + or + " " + rightExpression

  override def toMySQL: String = "( " + leftExpression.toMySQL + " or " + rightExpression.toMySQL + " )"

}
