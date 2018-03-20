package com.movieq.random

class Expression(string: String) {

  def and(expression: Expression): Expression = {
    this (string + " and " + expression)
  }

  def or(expression: Expression): Expression = {
    this (string + " or " + expression)
  }

  override def toString: String = string

}
