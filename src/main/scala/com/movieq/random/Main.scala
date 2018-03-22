package com.movieq.random

object Main extends App {

  def i(string: String): Identifier = Identifier(string)

  println(
    i("id").is(124).or(i("rating").greaterThen(7.2).or(i("productionCountry").is("someProductionCountry")))
      .and(i("people.name").contains("Salman Khan")).string()

  )
}
