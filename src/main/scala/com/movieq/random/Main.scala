package com.movieq.random

object Main extends App {
  println(
    And(
      Or(
        Is("id", 124),
        GreaterThen("rating", 7.2)
      ),
      Contains("people.name", "Salman Khan")
    ).string()
  )
}
