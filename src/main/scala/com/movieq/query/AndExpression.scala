package com.movieq.query

class AndExpression(leftExpression: FilterExpression, rightExpression: FilterExpression) extends FilterExpression {

  private val and = "and"

  override def toString: String = leftExpression + " " + and + " " + rightExpression

  override def toMySQLExpression: com.movieq.query.mysql.FilterExpression = new com.movieq.query.mysql.AndExpression(leftExpression.toMySQLExpression, rightExpression.toMySQLExpression)

}
