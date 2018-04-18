package com.movieq.query

class Search(domainObject: String, where: Where) {

  private val search = "search"

  def toMySQL: String = {
    "select * " + " from " + "movie" + " " + where.toMySQL
  }

  override def toString: String = search + " " + domainObject + " " + where
}

