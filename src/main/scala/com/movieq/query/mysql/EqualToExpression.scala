package com.movieq.query.mysql

class EqualToExpression(id: String, value: String) {

  private val equalTo = "="

  override def toString: String = id + " " + equalTo + " " + value

}
