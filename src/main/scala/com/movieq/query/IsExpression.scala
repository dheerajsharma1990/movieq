package com.movieq.query

class IsExpression(id: String, value: String) extends FilterExpression {

  private val is = "is"

  override def toString: String = id + " " + is + " " + value

  override def toMySQL: String =  id + " = " + value
}