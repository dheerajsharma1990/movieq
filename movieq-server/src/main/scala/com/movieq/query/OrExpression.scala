package com.movieq.query


class OrExpression(leftExpression: FilterExpression, rightExpression: FilterExpression) extends FilterExpression {

  private val or = "or"

  override def toString: String = leftExpression + " " + or + " " + rightExpression

  override def toSQLExpression: com.movieq.query.sql.FilterExpression = new com.movieq.query.sql.OrExpression(leftExpression.toSQLExpression, rightExpression.toSQLExpression)


}
