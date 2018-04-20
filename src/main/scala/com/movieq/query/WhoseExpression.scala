package com.movieq.query

class WhoseExpression(filterExpression: FilterExpression) extends Expression {

  private val whose = "whose"

  override def toMySQL: String = {
    "where" + " " + filterExpression.toMySQL
  }

  override def toString: String = whose + " " + filterExpression

}

object WhoseExpression {
  def apply(where: String): WhoseExpression = {
    val trimmedString = where.trim
    val (queryType, expression) = trimmedString.splitAt(5)
    if("where".equalsIgnoreCase(queryType)) {

    }
    throw new RuntimeException("Invalid query.")
  }
}
