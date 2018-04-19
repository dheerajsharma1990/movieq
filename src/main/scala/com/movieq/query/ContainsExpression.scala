package com.movieq.query

class ContainsExpression(id: String, value: String) extends FilterExpression {

  private val contains = "contains"

  override def toString: String = id + " " + contains + " " + value

  override def toMySQL: String = id + " like " + "%" + value + "%"

}
