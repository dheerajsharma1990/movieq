package com.movieq.random

case class Identifier[T](identifier: String) {

  def is(value: T): Expression = {
    Is(identifier, value)
  }

  def between(value1: T, value2: T): Expression = {
    Between(identifier, value1, value2)
  }


  def greaterThen(value: T): Expression = {
    GreaterThen(identifier, value)
  }

  def contains(value: T): Expression = {
    Contains(identifier, value)
  }

}
