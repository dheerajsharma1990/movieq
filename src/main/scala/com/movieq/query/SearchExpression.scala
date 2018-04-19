package com.movieq.query

class SearchExpression(domainObject: String, where: Where) extends Expression {

  private val search = "search"

  override def toMySQL: String  = {
    "select * " + " from " + "movie" + " " + where.toMySQL
  }

  override def toString: String = search + " " + domainObject + " " + where
}

