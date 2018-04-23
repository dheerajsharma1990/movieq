package com.movieq.query.sql

class SelectExpression(tableExpression: TableExpression, whereExpression: WhereExpression) extends SQLExpression {

  private val select = "select *"

  override def toString: String = select + " " + tableExpression + " " + whereExpression

}
