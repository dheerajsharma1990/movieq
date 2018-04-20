package com.movieq.query.mysql

class WhereExpression(filterExpression: FilterExpression) extends MySQLExpression {

  private val where = "where"

  override def toString: String = where + " " + filterExpression

}
