package com.movieq.query

class AndExpression(leftExpression: FilterExpression, rightExpression: FilterExpression) extends FilterExpression {

  private val and = "and"

  override def toString: String = leftExpression + " " + and + " " + rightExpression

  override def toSQLExpression: com.movieq.query.sql.FilterExpression = new com.movieq.query.sql.AndExpression(leftExpression.toSQLExpression, rightExpression.toSQLExpression)

}
