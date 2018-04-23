package com.movieq.query

import com.movieq.query.sql.{SQLExpression, SelectExpression}

class SearchExpression(domainExpression: DomainExpression, whoseExpression: WhoseExpression) extends Expression {

  private val search = "search"

  override def toSQLExpression: SQLExpression = new SelectExpression(domainExpression.toSQLExpression, whoseExpression.toSQLExpression)

  override def toString: String = search + " " + domainExpression + " " + whoseExpression
}

object SearchExpression {
  def apply(search: String): SearchExpression = {
    val trimmed = search.trim
    val queryType = search.trim.takeWhile(ch => ch != ' ')
    if ("search".equals(queryType)) {
      val remainder = search.trim.dropWhile(ch => ch != ' ')
      val domainObject = remainder.trim.takeWhile(ch => ch == ' ')
      val whereString = remainder.trim.dropWhile(ch => ch != ' ')
      val whereToken = whereString.trim.takeWhile(ch => ch == ' ')
    }
    throw new RuntimeException("Invalid query.")
  }
}

