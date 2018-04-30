package com.movieq.query

import com.movieq.query.sql.WhereExpression

class WhoseExpression(filterExpression: FilterExpression) extends Expression {

  private val whose = "whose"

  override def toSQLExpression: WhereExpression = new WhereExpression(filterExpression.toSQLExpression)

  override def toString: String = whose + " " + filterExpression

}

object WhoseExpression {
  def apply(whose: String): WhoseExpression = {
    val trimmedString = whose.trim
    val (queryType, expression) = trimmedString.splitAt(5)
    if("where".equalsIgnoreCase(queryType)) {

    }
    throw new RuntimeException("Invalid query.")
  }
}
