package com.movieq.query

class Search(domainObject: String, where: Where) {

  private val search = "search"

  override def toString: String = search + " " + domainObject + " " + where
}

