package com.movieq.query

class Where(filterExpression: FilterExpression) extends Expression {

  private val where = "where"

  override def toMySQL: String = {
    "where" + " " + filterExpression.toMySQL
  }

  override def toString: String = where + " " + filterExpression

}
