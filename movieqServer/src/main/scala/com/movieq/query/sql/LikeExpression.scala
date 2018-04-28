package com.movieq.query.sql

class LikeExpression(id: String, value: String) extends FilterExpression {

  private val like = "like"

  override def toString: String = id + " " + like + " " + "%" + value + "%"

}
