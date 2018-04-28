package com.movieq.query

import com.movieq.query.sql.SQLExpression

trait Expression {

  def toSQLExpression: SQLExpression

  override def toString: String

}
