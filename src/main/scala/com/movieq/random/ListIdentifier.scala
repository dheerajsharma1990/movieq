package com.movieq.random

case class ListIdentifier[T](identifier: String) {

  def contain(value: T): Expression = {
    Contains(identifier, value)
  }

}
