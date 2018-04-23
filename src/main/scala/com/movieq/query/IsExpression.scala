package com.movieq.query

import com.movieq.query.sql.EqualToExpression

class IsExpression(id: String, value: String) extends FilterExpression {

  private val is = "is"

  override def toString: String = id + " " + is + " " + value

  override def toSQLExpression: com.movieq.query.sql.FilterExpression =  new EqualToExpression(id, value)
}
