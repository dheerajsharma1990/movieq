package com.movieq.random

object Main extends App {
  println(
    new AndCondition(
      new OrCondition(
        new IsOperator("id",124),
        new GreaterThenOperator("rating", 7.2)
      ),
      new ContainsOperator("people.name","Salman Khan")
    ).string()
  )
}
