package com.movieq.random

import com.movieq.domain.{People, ProductionCountry}

object Main extends App {

  def i(string: String) = Identifier[Int](string)
  def s(string: String) = Identifier[String](string)
  def d(string: String) = Identifier[Double](string)
  def pc(string: String) = Identifier[ProductionCountry](string)
  def ppl(string: String) = ListIdentifier[People](string)

  println(
    i("id").is(124).or(d("rating").greaterThen(7.2).or(pc("productionCountry").is(new ProductionCountry("US","America"))))
      .and(
        s("people.name").contain("Salman Khan")
          .or(ppl("people").contain(new People(1,"Shahrukh",52)))
      ).string()

  )
}
