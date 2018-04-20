package com.movieq.query


class OrExpression(leftExpression: FilterExpression, rightExpression: FilterExpression) extends FilterExpression {

  private val or = "or"

  override def toString: String = leftExpression + " " + or + " " + rightExpression

  override def toMySQLExpression: com.movieq.query.mysql.FilterExpression = new com.movieq.query.mysql.OrExpression(leftExpression.toMySQLExpression, rightExpression.toMySQLExpression)


}
