package com.movieq.query.sql

class WhereExpression(filterExpression: FilterExpression) extends SQLExpression {

  private val where = "where"

  override def toString: String = where + " " + filterExpression

}
