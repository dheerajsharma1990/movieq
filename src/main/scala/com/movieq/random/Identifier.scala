package com.movieq.random

case class Identifier(identifier: String) {

  def is(value: Any): Expression = {
    Is(identifier, value)
  }

  def greaterThen(value: Any): Expression = {
    GreaterThen(identifier, value)
  }

  def contains(value: Any): Expression = {
    Contains(identifier, value)
  }

}
