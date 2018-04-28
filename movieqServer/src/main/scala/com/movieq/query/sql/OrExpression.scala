package com.movieq.query.sql

class OrExpression(leftExpression: FilterExpression, rightExpression: FilterExpression) extends FilterExpression {

  private val or = "or"

  override def toString: String = "(" + leftExpression + " " + or + " " + rightExpression + ")"

}
