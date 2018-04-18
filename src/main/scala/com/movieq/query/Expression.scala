package com.movieq.query

trait Expression {

  def toMySQL: String

  override def toString: String

}
