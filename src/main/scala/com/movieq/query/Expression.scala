package com.movieq.query

import com.movieq.query.mysql.MySQLExpression

trait Expression {

  def toMySQLExpression: MySQLExpression

  override def toString: String

}
