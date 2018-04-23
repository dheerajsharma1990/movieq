package com.movieq.query.sql

class EqualToExpression(id: String, value: String) extends FilterExpression {

  private val equalTo = "="

  override def toString: String = id + " " + equalTo + " " + value

}
