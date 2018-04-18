package com.movieq.query

class Where(expr: Expression) {

  private val where = "where"

  def toMySQL: String = {
    "where" + " " + expr.toMySQL
  }

  override def toString: String = where + " " + expr

}
