package com.movieq.random

class Expression(string: String) {

  def and(expression: Expression): Expression = {
    new Expression("(" + string + " and " + expression + ")")
  }

  def or(expression: Expression): Expression = {
    new Expression("(" + string + " or " + expression + ")")
  }

  override def toString: String = string

}
