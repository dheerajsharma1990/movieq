package com.movieq.query.mysql

class LikeExpression(id: String, value: String) extends FilterExpression {

  private val like = "like"

  override def toString: String = id + " " + like + " " + "%" + value + "%"

}
