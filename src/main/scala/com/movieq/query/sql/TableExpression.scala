package com.movieq.query.sql

class TableExpression(string: String) extends SQLExpression {

  private val from = "from"

  override def toString: String = "from" + " " + string

}
