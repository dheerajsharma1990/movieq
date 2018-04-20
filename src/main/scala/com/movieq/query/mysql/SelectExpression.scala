package com.movieq.query.mysql

class SelectExpression(tableName: String, whereExpression: WhereExpression) extends MySQLExpression {

  private val search = "search"

  override def toString: String = search + " " + tableName + " " + whereExpression

}
