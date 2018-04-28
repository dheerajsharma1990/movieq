package com.movieq.random

case class ListIdentifier[T](identifier: String) {

  def contains(value: T): Expression = {
    Contains(identifier, value)
  }

}
