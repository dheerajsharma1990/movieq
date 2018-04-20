package com.movieq.query

import com.movieq.query.mysql.EqualToExpression

class IsExpression(id: String, value: String) extends FilterExpression {

  private val is = "is"

  override def toString: String = id + " " + is + " " + value

  override def toMySQLExpression: com.movieq.query.mysql.FilterExpression =  new EqualToExpression(id, value)
}
