package com.movieq.query

import com.movieq.query.mysql.LikeExpression

class ContainsExpression(id: String, value: String) extends FilterExpression {

  private val contains = "contains"

  override def toString: String = id + " " + contains + " " + value

  override def toMySQLExpression: com.movieq.query.mysql.FilterExpression = new LikeExpression(id, value)

}
