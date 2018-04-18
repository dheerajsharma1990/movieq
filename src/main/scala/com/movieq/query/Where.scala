package com.movieq.query

class Where(expr: Expression) {

  private val where = "where"

  override def toString: String = where + " " + expr

}
