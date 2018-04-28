package com.movieq.random

trait Expression {

  def or(expression: Expression): Expression = Or(this, expression)

  def and(expression: Expression): Expression = And(this, expression)

  def string(): String
}
