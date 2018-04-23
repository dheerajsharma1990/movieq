package com.movieq.query

import com.movieq.query.sql.LikeExpression

class ContainsExpression(id: String, value: String) extends FilterExpression {

  private val contains = "contains"

  override def toString: String = id + " " + contains + " " + value

  override def toSQLExpression: com.movieq.query.sql.FilterExpression = new LikeExpression(id, value)

}
