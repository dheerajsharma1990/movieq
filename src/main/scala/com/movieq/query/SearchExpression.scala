package com.movieq.query

class SearchExpression(domainObject: String, where: WhoseExpression) extends Expression {

  private val search = "search"

  override def toMySQL: String = {
    "select * " + " from " + "movie" + " " + where.toMySQL
  }

  override def toString: String = search + " " + domainObject + " " + where
}

object SearchExpression {
  def apply(search: String): SearchExpression = {
    val trimmed = search.trim
    val queryType = search.trim.takeWhile(ch => ch != ' ')
    if("search".equals(queryType)) {
      val remainder = search.trim.dropWhile(ch => ch != ' ')
      val domainObject = remainder.trim.takeWhile(ch => ch == ' ')
      val whereString = remainder.trim.dropWhile(ch => ch != ' ')
      val whereToken = whereString.trim.takeWhile(ch => ch == ' ')
    }
    throw new RuntimeException("Invalid query.")
  }
}

